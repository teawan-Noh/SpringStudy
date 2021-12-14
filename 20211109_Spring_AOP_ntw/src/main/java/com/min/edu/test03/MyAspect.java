package com.min.edu.test03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspect {
	
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	public void throwing() {
		System.out.println("쉬는 날이다");
	}
	
	public void after() {
		System.out.println("강의실을 나간다");
	}
}
