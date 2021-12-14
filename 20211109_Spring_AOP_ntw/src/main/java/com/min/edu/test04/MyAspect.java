package com.min.edu.test04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	
	//Pointcut으로 사용할 empty 메소드를 생성한다.
	@Pointcut("execution(public * *(..))")
	public void myClass() {}
	
	@Before("myClass()")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("강의실을 나간다");
	}
}
