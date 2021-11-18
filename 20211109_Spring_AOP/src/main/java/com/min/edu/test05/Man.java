package com.min.edu.test05;

import org.springframework.stereotype.Component;

@Component
public class Man implements Person {

	@Override
	public void classWork() {
		System.out.println("뉴스를 본다");
	}

}
