package com.min.edu.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01_Main {

	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("com/min/edu/test01/beans.xml");
		
		NickNamePrn my = app.getBean("nickNamePrn", NickNamePrn.class);
		System.out.println(my);
	}

}
