package com.min.edu.dtos;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String filename; //파일
	private String desc; //textarea 영역
	private MultipartFile file;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
}
