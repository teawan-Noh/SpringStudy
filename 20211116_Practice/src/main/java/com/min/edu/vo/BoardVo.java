package com.min.edu.vo;

public class BoardVo {
	//화면에서 전달할 수 있는 객체는 String 뿐
	// <form action="./insert.do"><input type="text" name="id"/><input type="submit" value="전송"/></from>
	// com.min.edu.ctrl.InsertServlet.java
	// String id = request.getParameter("id");
	// int idNum = Integer.parseInt("id");
	// BoardVo vo = New BoardVo();
	// vo.setInt(idNum);
	
	private int seq;
	private String title;
	private String content;
	private String regdate;
	
	public BoardVo() {
	}

	public BoardVo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public BoardVo(int seq, String title, String content, String regdate) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", content=" + content + ", regdate=" + regdate + "]";
	}

}
