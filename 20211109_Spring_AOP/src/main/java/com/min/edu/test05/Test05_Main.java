package com.min.edu.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05_Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/min/edu/test05/aopContext.xml");
		Person pp =
		context.getBean("woman",Person.class);
		
		pp.classWork();
		
	}
}
