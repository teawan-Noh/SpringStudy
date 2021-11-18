package com.min.edu.test02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/*
 *  13줄,20줄,24줄 pointcut execution expression 표현식 대상이 되는 메소들 선택
 *  *(모든것), (..)모든타입의 아큐먼트와 모든 갯수 ,ex (String, String)
 *   public void com.min.edu.test02.*.classWork(..))
 *   
 */

@Aspect
public class MyAspect {

	@Before("execution(public void com.min.edu.test02.*.*(..))")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@AfterThrowing(pointcut = "execution(public void com.min.edu.test02.*.*(..))")
	public void throwing() {
		System.out.println("쉬는 날이다");
	}
	@After("execution(public void com.min.edu.test02.*.*(..))")
	public void after() {
		System.out.println("강의실을 나간다");
	}
	
}
