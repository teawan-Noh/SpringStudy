package com.min.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerBoard_VO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class DBConnectionTest {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private IAnswerboardDao dao;
	
	@Bean
	public void before() {
//		sqlSessionTemplate 테스트할  bean 객체
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
		System.out.println("DB 연결테스트"+session.toString() + "####");
	}
	
	@Test
	public void connectionTest() {
		List<AnswerBoard_VO> obj = dao.selectAllBoard();
		assertNotNull(obj);
	}
	
}
