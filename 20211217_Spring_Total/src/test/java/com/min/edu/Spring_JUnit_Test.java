package com.min.edu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.Member_Dto;
import com.min.edu.dto.RowNum_Dto;
import com.min.edu.model.IAnswerBoardDao;
import com.min.edu.model.IMemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Spring_JUnit_Test {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private IMemberDao dao;
	
	@Autowired
	private IAnswerBoardDao adao;
	
	
	@Test
	public void test() {
//		assertNotNull(context);
//		assertNotNull(sqlSession);
//		assertNotNull(dao);
		
//		assertNotNull(dao.memberList());
		
//		Member_Dto dto 
//		= new Member_Dto("USER03", "USER03", "1234", null, null, null);
//		assertTrue(dao.signupMember(dto));
		
//		assertTrue(dao.idDuplicateCheck("USER03"));
		
//		Map<String, Object> map= 
//				new HashMap<String, Object>();
//		map.put("id", "USER03");
//		map.put("pw", "1234");
//		assertNotNull(dao.loginMember(map));
		
//		assertNotNull(dao.selStringPw("USER03"));
//		assertNotNull(dao.enLogin("USER03"));
		
//		Map<String, Object> map =
//				new HashMap<String, Object>();
//		map.put("delflag", "N");
//		map.put("id", "USER02");
//		
//		assertTrue(dao.chageUser(map));
		
//		AnswerBoard_Dto dto = 
//				new AnswerBoard_Dto();
//		dto.setId("USER03");
//		dto.setTitle("USER03이 새글 작성");
//		dto.setContent("새글 내용 작성 중");
//		
//		assertTrue(adao.writeBoard(dto));
		
		
//		AnswerBoard_Dto dto =
//				new AnswerBoard_Dto();
//		dto.setSeq(1);
//		dto.setId("USER02");
//		dto.setTitle("USER02 답글 입력");
//		dto.setContent("USER02 답글 내용 입력");
//		
//		adao.replyUpdate(dto);
//		adao.replyInsert(dto);
		
		assertNotNull(adao.getOneBoard("1")); 
		
//		adao.readCountBoard("1");
//		Map<String, String[]> map =
//				new HashMap<String, String[]>();
//		map.put("seqs", new String[] {"2"});
//		assertTrue(adao.delflagBoard(map)); 
		
//		List<AnswerBoard_Dto> lists=
//				adao.deleteBoardSel("1");
//		for (AnswerBoard_Dto dto : lists) {
//			System.out.println(dto);
//		}
		
//		List<String> seqs = 
//				new ArrayList<String>();
//		seqs.add("2");
//		adao.deleteBoard(seqs);
		
		
//		List<AnswerBoard_Dto> lists=
//				adao.userBoardList();
//		for (AnswerBoard_Dto dto : lists) {
//			System.out.println(dto);
//		}
		
//		RowNum_Dto rdto = 
//				new RowNum_Dto();
//		List<AnswerBoard_Dto> lists =
//				adao.userBoardListRow(rdto);
//		for (AnswerBoard_Dto dto : lists) {
//			System.out.println(dto);
//		}
		
//		System.out.println(adao.userBoardListTotal());
	}

}






