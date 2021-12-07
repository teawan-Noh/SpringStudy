package com.min.edu.vo;

/**
 * hr 계정의 happymember와 매핑되는 VO/DTO 클레스
 * @author taewanNoh
 * @since 2021. 11. 25
 */
public class Member_VO {

	private String id;
	private String name;
	private String pw;
	private String auth;
	private String delflag;
	private String regdate;
	
	public Member_VO() {
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member_VO [id=" + id + ", name=" + name + ", pw=" + pw + ", auth=" + auth + ", delflag=" + delflag
				+ ", regdate=" + regdate + "]";
	}
	
}
