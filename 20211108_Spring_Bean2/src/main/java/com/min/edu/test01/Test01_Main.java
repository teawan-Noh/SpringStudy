package com.min.edu.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01_Main {

	public static void main(String[] args) {
		//TODO 003.이전 POJO를 실행 시키는 방법 -> new 연산자를 통해서 생성 호출
//		MessageBean msg = new MessageBeanImpl();
//		msg.sayHello();
		//TODO 005. 이전 POJO를 생성자 오버로딩을 통해서 실행
//		MessageBean msg2 = new MessageBeanImpl("banana", 1000);
//		msg2.sayHello();
		
		//TODO 004. Spring Bean Configuration에 등록하여 POJO 객체를 Spring Bean으로 사용
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("com/min/edu/test01/Beans.xml");
		
		MessageBean stb = (MessageBean)factory.getBean("strawberry");
		stb.sayHello();
		
		//TODO 006. Spring Bean을 통해서 생성자의 값을 입력
		MessageBean stb2 = (MessageBean)factory.getBean("banana");
		stb2.sayHello();
		
		MessageBean stb3 = (MessageBean)factory.getBean("apple");
		stb3.sayHello();
	}

}
