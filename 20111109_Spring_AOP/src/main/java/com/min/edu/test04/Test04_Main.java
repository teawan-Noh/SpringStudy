package com.min.edu.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04_Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/min/edu/test04/aopContext.xml");
		Person p =  context.getBean("woman",Person.class);
		p.classWork();
	}

}
