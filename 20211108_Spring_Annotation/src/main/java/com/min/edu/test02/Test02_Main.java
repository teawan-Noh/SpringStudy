package com.min.edu.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02_Main {

	public static void main(String[] args) {
		ApplicationContext app =
				new ClassPathXmlApplicationContext("com/min/edu/test02/beans.xml");
		
		NickNamePrn my = app.getBean("nickNamePrn", NickNamePrn.class);
		System.out.println(my);

	}

}
