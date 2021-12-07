package com.min.edu.vo;

import java.util.Date;

public class UserVo {

	 private String id;
	 private String name;
	 private String pw;
	 private String auth;
	 private String delflag;
	 private Date regdate;
	 
	 public UserVo() {
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
