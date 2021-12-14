package com.min.edu.dtos;

public class ListDto {
	private String title;
	private String regdate;

	
	public ListDto(String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public ListDto(String title, String regdate) {
		super();
		this.title = title;
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ListDto [title=" + title + ", regdate=" + regdate + "]";
	}
	public ListDto() {
	}
}
