package com.min.edu;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *  JUnit Test를 Spring Container에 맞춰 실행 할 수 있도록 설정
 *  org.springframework.context.ApplicationContext 객체를 선언해 줘야함
 *  
 *  Spring을 사용하면 모든 환경(spring bean configuration)은 모두 xml로 작성하여
 *  DispatcherServlet에 의해서 읽혀서 bean으로 등록 후 사용이 가능하다     
 *  
 *  ******* 중요 *****
 *  bean을 테스트 하기 위해서 20211108_Spring_Bean2 프로잭트의 main메소드와 같은 ApplicationContext 객체가 필요함
 *  ApplicationContext 객체를 생성하기 위해서는 bean을 생성하기 위한 Spring bean Configuration xml 설정이 있어야함
 *  
 *  JUnit에서는 Spring test를 @ContextConfiguration을 통해서 읽고 사용할 수 있다.
 *  @ContextConfiguration은 물리적인 위치를 작성해야한다.
 *  만약 여러개의 xml파일을 설정한다면 ({xml,xml})
 *  
 *  spring bean을 test하기 위해서는 Spring-test 라이브러리가 필요
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/root-context.xml")
public class DBConnectionTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void connectionTest() {
//		sqlSessionTemplate 테스트할  bean 객체
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		System.out.println(session.toString());
	}
	
}
