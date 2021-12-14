package com.min.edu.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05_Main {

	public static void main(String[] args) {
		
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("com/min/edu/test05/applicationContext.xml");
		
		UserService user = app.getBean("userServiceImpl", UserService.class);
		user.addUser();
	}

}
