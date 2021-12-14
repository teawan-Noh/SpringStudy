package com.min.edu.test02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * 15, 20, 24줄 : pointcut execution expression 표현식 : 대상이 되는 메소드를 선택하기위한 표현식
 *   * : 모든것, (..):모든 타입의 아규먼트와 모든 갯수, ex(String, String)
 *   ("execution(public void com.min.edu.test02.*.*(..))") *모든클레스, *모든 메소드, (..)모든 아규먼트를 aop로 묶는다
 *   public void com.min.edu.test02.*.classWork(..) 메소드가 classWork인 애를 묶어라
 */

@Aspect
public class MyAspect {
	
	@Before("execution(public void com.min.edu.test02.*.*(..))")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@AfterThrowing(pointcut="execution(public void com.min.edu.test02.*.*(..))")
	public void throwing() {
		System.out.println("쉬는 날이다");
	}
	
	@After("execution(public void com.min.edu.test02.*.*(..))")
	public void after() {
		System.out.println("강의실을 나간다");
	}
}
