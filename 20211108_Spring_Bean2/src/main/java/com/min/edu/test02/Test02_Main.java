package com.min.edu.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02_Main {

	public static void main(String[] args) {

		ApplicationContext app =
				new ClassPathXmlApplicationContext("com/min/edu/test02/Beans.xml");
		
		JobAddress joblee = app.getBean("lee",JobAddress.class);
		System.out.println(joblee);
		
		JobAddress jobkim = app.getBean("kim",JobAddress.class);
		System.out.println(jobkim);
	}

}
