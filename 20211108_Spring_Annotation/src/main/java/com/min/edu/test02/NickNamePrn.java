package com.min.edu.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NickNamePrn {
	
	@Autowired
	private NickName a;
	
	public NickNamePrn() {
	}

	public NickName getA() {
		return a;
	}

	public void setA(NickName nickName) {
		this.a = nickName;
	}

	@Override
	public String toString() {
		return "NickNamePrn [nickName=" + a + "]";
	}
	
	
}
