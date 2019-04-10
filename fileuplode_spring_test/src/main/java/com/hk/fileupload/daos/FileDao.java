package com.hk.fileupload.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.fdto.FileDto;


@Repository
public class FileDao implements IFileDao {
	@Autowired
	private SqlSessionTemplate sqlsesion;
	private String namespace = "com.hk.fileboard.";
	

	@Override
	public boolean insertFileInfo(FileDto dto) {
	
		int count = sqlsesion.insert(namespace + "insertfile", dto);
		
		return count>0?true:false;
	}

	@Override
	public List<FileDto> getFileList() {


		return sqlsesion.selectList(namespace+"filelist");
	}

	@Override
	public FileDto getFile(int seq) {
	
		return sqlsesion.selectOne(namespace+"getfile",seq);
	}
	
	

}
