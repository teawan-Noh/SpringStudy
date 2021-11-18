package com.min.edu.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03_Main {

	public static void main(String[] args) {

		ApplicationContext app = 
				new ClassPathXmlApplicationContext("com/min/edu/test03/beans.xml");
		
		School sc = app.getBean("myschool", School.class);
		System.out.println(sc);
	}

}
