package com.hk.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.fdto.FileDto;
import com.hk.fileupload.service.IFileService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IFileService fileService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	

	@RequestMapping(value = "fileupload.do", method = RequestMethod.GET)
	public String fileupload(Locale locale, Model model) {
		logger.info("fileupload 가자 {}.", locale);
		
		
		return "fileupload";
	}
	
	
	@RequestMapping(value = "fileinsert.do", method = RequestMethod.POST)
	public String fileinsert(Locale locale, Model model, HttpServletRequest request) {
		logger.info("fileupload 가자 {}.", locale);
		
		boolean isS = fileService.insertFileInfo(request);
		
		if(isS) {
			return "fileupload";
		}else {
			logger.info("파일 업로드 실패");
			return "error";
		}
		
	}
	
	@RequestMapping(value = "downloadList.do", method = RequestMethod.GET)
	public String downloadList(Locale locale, Model model, HttpServletRequest request) {
		logger.info("downloadList 가자 {}.", locale);
		
		List<FileDto> list = fileService.getFileList();
		
		model.addAttribute("list",list);
		
		
		
		return "filelist";

	}
	
	
	@RequestMapping(value = "download.do", method = RequestMethod.GET)
	public void download(Locale locale, Model model, int seq,HttpServletResponse response) throws IOException {
		logger.info("download 가자 {}.", locale);
		
		FileDto dto = fileService.getFile(seq);
		
		String orignFileName = dto.getOrigin_fname(); //원본파일명
		String storedFileName=dto.getStored_fname(); //저장된 파일명
		
		//저장된 파일 읽ㅇ오기
		
		byte[] fileByte = FileUtils.readFileToByteArray(new File("D:/src/fileupload_download_0328/WebContent/upload/"+storedFileName));
		
		response.setContentType("application/octet-stream");
		
		String encoding = new String(orignFileName.getBytes("utf-8"),"8859_1");
		
		response.setHeader("Content-Disposition", "attachment; fileName="+ encoding);
		
		
		//파일 내보내는 작업
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
		
	

	}
	
	
	
	
	
	
	
	
	
	
	
}
