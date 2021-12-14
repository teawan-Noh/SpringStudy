package com.min.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerboardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class DBTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private IAnswerboardDao dao;
	
	@Bean
	public void before() {
		SqlSessionTemplate session = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
	}
	
	@Test
	public void connectionTest() {
		
//		selectAllBoard
		assertNotNull(dao.selectAllBoard());
		
//		selectOneBoard
//		assertNotNull(dao.selectOneBoard(41));
		
//		insertBoard
//		AnswerboardVO vo = new AnswerboardVO();
//		vo.setId("TESTUSER110");
//		vo.setTitle("테스트제목111");
//		vo.setContent("테스트내용111");
//		int cnt = dao.insertBoard(vo);
//		assertEquals(1, cnt);
		
//		updateBoard
//		AnswerboardVO vo = new AnswerboardVO();
//		vo.setSeq(41);
//		vo.setContent("41수정테스트입니다");
//		int cnt = dao.updateBoard(vo);
//		assertEquals(1, cnt);
		
//		deflagBoard
//		String[] seqs = {"41"};
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("seqs", seqs);
//		int cnt = dao.delflagBoard(map);
//		assertEquals(1, cnt);
		
//		deleteBoard
//		String[] seqs = {"41", "2"};
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("seqs", seqs);
//		int cnt = dao.deleteBoard(map);
//		assertEquals(1, cnt);
		
//		reply
//		AnswerboardVO vo = new AnswerboardVO();
//		vo.setSeq(22);
//		vo.setId("사용자43");
//		vo.setTitle("22번에 답글추가");
//		vo.setContent("답글달기");
//		dao.replyUp(vo);
//		dao.replyIn(vo);
	}
	
}
