package com.min.edu.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03_Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/min/edu/test03/aopContext.xml");
		Person pp = context.getBean("woman",Person.class);
		pp= context.getBean("man",Person.class);
		
		pp.classWork();
	}

}
