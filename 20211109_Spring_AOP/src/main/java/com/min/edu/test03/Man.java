package com.min.edu.test03;

// 클래스 bean으로 만들기 위해서 했던 방법
// @component, spring bean <bean>를 사용해여 등록 한다
// bean으로 만들어 지면 아이콘s가 붙음
public class Man implements Person {

	@Override
	public void classWork() {
		System.out.println("뉴스를 본다");
	}

}
