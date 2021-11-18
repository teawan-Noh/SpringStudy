package com.min.edu.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04_Main {

	public static void main(String[] args) {
		
		ApplicationContext app =
				new ClassPathXmlApplicationContext("com/min/edu/test04/Beans.xml");
		
		// factory design pattern : 분기 패턴
		// 기능 : 여러개의 기능을 가진 interface를 구현한 자식 객체를 하나의 객체명을 통해 호출 함 
		// interface로 구현했기 때문에 호출명이 같아짐 : OCP의 기초
		//컴포넌트명으로 호출 
//		TV tv = (TV)app.getBean("samsung");
		TV tv = (TV)app.getBean("lg");
		tv.powerOff();
		tv.powerOn();
	}

}
