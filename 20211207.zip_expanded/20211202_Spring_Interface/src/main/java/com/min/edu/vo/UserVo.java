package com.min.edu.vo;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserVo {
	//validator @NotNull
	@NotNull
	@Size(min = 4, max = 50, message = "잘못된 입력값 입니다")
	private String id;
	
	@NotNull
	@Size(min = 4, max = 50, message = "잘못된 이름 입니다")
	private String name;
	
	@NotEmpty(message = "필수 입력값 입니다")
	private String pw;
	
	private String auth;
	private String delflag;
	private Date regdate;
	
	public UserVo() {
	}
	
	public UserVo(String id, String name, String pw, String auth, String delflag, Date regdate) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + ", pw=" + pw + ", auth=" + auth + ", delflag=" + delflag
				+ ", regdate=" + regdate + "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
