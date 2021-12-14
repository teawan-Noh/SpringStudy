package com.min.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.IDao;
import com.min.edu.model.IUserDao;
import com.min.edu.vo.EduVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SpringJunit_Test {
	//junit테스트할때는 서버 끄고 하기
	
	
	/*
	 * ApplicationContext : 
	 * DispatcherServlet에 의해서 Bean으로 등록되는 과정이 아닌
	 * @ContextConfiguration의 Annotation을 통해서 생성된 Bean을 사용하기 위한 객체
	 */
	@Autowired
	private ApplicationContext context;
	
	
	/*
	 * SqlSessionTemplate :
	 * bean중에서 root-context.xml에 의해서 생성된 한개의 SqlSessionTemplate bean을 DI
	 */
	@Autowired
	private SqlSessionTemplate session;
	
	/*
	 * servlet-context.xml의 <context:conponent-scan base-package="com.min.edu">에 의해서
	 * base-package 하위에 있는 org.springframework.stereotype인 @Component, @Controller, @Service, @Repository를 통해서
	 * 생성된 Bean.
	 * OCP구조에 의해서
	 * DaoImpl dao = new DaoImpl(); 이어야 하지만 implements 구조의 다형성 발생에 의해서 
	 * 부모의 이름으로 자식을 호출할 수 있는 형태인 IDao dao = new DaoImpl();로 기능을 동작시킨다.
	 */
	@Autowired
	private IDao dao;
	
	@Autowired
	private IUserDao udao;
	
	
	//단위테스트
	@Test
	public void test() {
//		assertNotNull(context);
		
//		assertNotNull(session);
		
		//selectList는 데이터가 없어도 빈 List객체가 생기므로 null이 될 수 없다.
//		assertNotEquals(0, dao.selectBoard().size());
		
		/*
		 * 시나리오
		 * selectKey에 의해서 자동으로 seq 입력 Parameter인 setSeq
		 */
		EduVo vo = new EduVo();
		vo.setId("USER01");
//		vo.setTitle("Test jUnit");
		assertEquals(1, udao.getCheckUser("USER01"));
		
//		assertNotEquals(0, dao.updateBoard());
		
	}

}
