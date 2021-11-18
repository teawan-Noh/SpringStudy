package com.min.edu.test03;


import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04_Main {

	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("com/min/edu/test03/applicationContext.xml");
		
		//java의 내부 클레스인 Date를 bean으로 생성하여 호출
		System.out.println(app.getBean("now", Date.class)); 
		System.out.println(app.getBean("mydate", Date.class)); 
		
		//bean을 통해서 setter한 값을 bean을 자바로 생성해서 getter로 값을 출력
		UserDto dto = app.getBean("mydto", UserDto.class);
		System.out.println(dto.getPer());
		System.out.println(dto.getUserName());
		
		//userServic 객체를 만들고 
		//bean에서 java로 변경을 한 후 
		//위에서 생선된 dto를 addUser 메소드를 통해서 입력
		
		//UserService는 setter를 가지고 있지 않기 때문에
		//<bean ref=>를 통해서 생성된 bean을 주입받을 수 없다.
		UserService service = (UserServiceImpl)app.getBean("myService");
		service.addUser(dto);
	}

}
