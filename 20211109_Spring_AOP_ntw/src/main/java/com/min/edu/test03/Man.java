package com.min.edu.test03;

//클래스를 bean으로 만들기 위해서 했던 방법
//@Component 사용 or spring bean에 <bean>으로 등록한다
//bean으로 만들어지면 아이콘에 s가 붙음
public class Man implements Person {

	@Override
	public void classWork() {
		System.out.println("뉴스를 본다");

	}

}
