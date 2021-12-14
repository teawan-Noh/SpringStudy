package com.min.edu.test05;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person {

	@Override
	public void classWork() {
		System.out.println("코드를 작성한다");

	}

}
