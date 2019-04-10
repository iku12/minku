package com.hk.fileupload.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.fdto.FileDto;
import com.hk.fileupload.daos.IFileDao;


@Service
public class FileService implements IFileService {
	
	@Autowired
	private IFileDao fileDao; // 느슨한 결합을 유지 --인터페이스 구현
	

	@Override
	public boolean insertFileInfo(HttpServletRequest request) {
		
		boolean isS =true;
		
		//Multipart 요청 정보도 HttpServletREquest 객체를 통해서 전달된다.
		//HttpServletRequest 객체가 바로 MultipartFile을 처리 못한다
		//MultipartHttpServletRequest) request 형변환
		MultipartHttpServletRequest multi =  (MultipartHttpServletRequest) request;
		
		//요철파일 가져오기
		
		MultipartFile multifile = multi.getFile("filename");
		
		//db에 파일 정보 저장하기 (orign_fname,stored_fname,file_size)
		
		//요청한 파일에서 원본 파일명 구하기
		String orign_fname = multifile.getOriginalFilename();
		
		
		//32자리.txt
		String creatUUID = UUID.randomUUID().toString().replaceAll("-","");
		
		//stored_name 저장할 파일명 만들어서 구하기
		String stored_fname = creatUUID + orign_fname
							.substring(orign_fname.lastIndexOf("."));
		
		int file_size =(int)multifile.getSize();
		
		//파일객체 구하기
		
		File f =new File("D:/src/fileupload_download_0328/WebContent/upload/"+stored_fname);
		
		
		try {
			multifile.transferTo(f);//파일객체의 경로대로 업로드 실행
			isS = fileDao.insertFileInfo(new FileDto(orign_fname,stored_fname,file_size));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isS;
		
	}

	@Override
	public List<FileDto> getFileList() {
		// TODO Auto-generated method stub
		return fileDao.getFileList();
	}

	@Override
	public FileDto getFile(int seq) {
		// TODO Auto-generated method stub
		return fileDao.getFile(seq);
	}

}
