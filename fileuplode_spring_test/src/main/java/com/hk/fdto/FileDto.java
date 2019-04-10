package com.hk.fdto;

import java.util.Date;

public class FileDto {

	private int seq;
	private String origin_fname; 	//원본파일
	private String stored_fname; 	//저장파일명
	private int file_size;			//파일사이즈
	private Date f_regdate;			//파일업로드날짜
	private String f_delflag;		//파일삭제
	
	
	
	
	
	
	public FileDto() {
		super();
		
	}



	public FileDto(int seq, String origin_fname, String stored_fname, int file_size, Date f_regdate, String f_delflag) {
		super();
		this.seq = seq;
		this.origin_fname = origin_fname;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
		this.f_regdate = f_regdate;
		this.f_delflag = f_delflag;
	}



	public FileDto(String origin_fname, String stored_fname, int file_size) {
		super();
		this.origin_fname = origin_fname;
		this.stored_fname = stored_fname;
		this.file_size = file_size;
	}



	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}



	public String getOrigin_fname() {
		return origin_fname;
	}



	public void setOrigin_fname(String origin_fname) {
		this.origin_fname = origin_fname;
	}



	public String getStored_fname() {
		return stored_fname;
	}



	public void setStored_fname(String stored_fname) {
		this.stored_fname = stored_fname;
	}



	public int getFile_size() {
		return file_size;
	}



	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}



	public Date getF_regdate() {
		return f_regdate;
	}



	public void setF_regdate(Date f_regdate) {
		this.f_regdate = f_regdate;
	}



	public String getF_delflag() {
		return f_delflag;
	}



	public void setF_delflag(String f_delflag) {
		this.f_delflag = f_delflag;
	}






	
	
	
	
	
}
