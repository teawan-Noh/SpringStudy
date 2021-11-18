package com.min.edu.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02_Main {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/min/edu/test02/aopContext.xml");
		
		
		// aspect의 Proxy를 연결하지 않으면 CCC가 연결되어 Weaving이 될 수 없음
		// 따라서 spring bean xml proxy 설정
		Person p =  context.getBean("woman", Person.class);
		p.classWork();
		p =context.getBean("man", Person.class);
		p.classWork();
		
	}
}



