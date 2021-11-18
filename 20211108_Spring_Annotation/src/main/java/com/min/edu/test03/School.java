package com.min.edu.test03;

import javax.annotation.Resource;

public class School {
	
	//Spring 4.3.25 : @Resource는 javax 라이브러리가 빠짐 그래서 dependency를 추가해줘야 함
	// java 1.8부터 jdk achitecture 모델이 변경 => deprecate(삭제대상) 정리
	//javax.annotation
	
	//<context:component-scan>을 통해서 @(Annotaion)으로 되어 있는 bean을 사용할 수 있도록 해줌
	//xml class를 bean으로 등록 했다면 xml에서 ref를 통해서 주입을 해줘야함
	// 하지만 지금은 @Resource를 통해서 주입하고자 했지만 @Resource가 bean을 가져오지 못한이유는 java기 떄문에
	// 해결방법 : @Resource인 annotation을 사용할 수 있도록 해줘야 함.
	// xml에 <context:annotation-config>를 작성 
	@Resource(name = "mystu1")
	private Student person;
	
	private int grade;

	public School() {
		super();
	}

	public School(Student person) {
		super();
		this.person = person;
	}

	@Override
	public String toString() {
		return "School [person=" + person + ", grade=" + grade + "]";
	}

	public Student getPerson() {
		return person;
	}

	public void setPerson(Student person) {
		this.person = person;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
