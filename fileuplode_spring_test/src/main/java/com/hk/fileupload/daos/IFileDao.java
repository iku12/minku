package com.hk.fileupload.daos;

import java.util.List;

import com.hk.fdto.FileDto;

public interface IFileDao {
	   
	   //파일업로드를 통해 파릴정보를 Db에 저장하는 기능
	   public boolean insertFileInfo(FileDto dto);
	   
	   //파일정보 목록을 보여주기
	   
	   public List<FileDto> getFileList();
	   
	   //파일하나에 대한 정보 보여주기
	   public FileDto getFile(int seq);
	
}
