package com.min.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.dao.IMemberDao;
import com.min.edu.vo.Member_VO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml") // spring하위의 모든폴더중 모든xml
public class MemberTest {

	@Autowired
	private IMemberDao dao;
	
	@Test
	public void test() {
//		getLogin
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "USER01");
		map.put("pw", "1234");
		assertNotNull(dao.getLogin(map));
		
//		memberList
//		assertNotNull(dao.memberList());
		
//		signupMember
//		Member_VO vo = new Member_VO();
//		vo.setId("USERTEST2");
//		vo.setName("테스터2");
//		vo.setPw("1234");
//		assertNotEquals(1, dao.signupMember(vo));
		
//		idDuplicateCheck
//		System.out.println(dao.idDuplicateCheck("USER01"));
//		
//		loginMember
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "USER01");
//		map.put("pw", "1234");
		
//		selStringPW
//		enterLogin
//		ChangeUser

	}

}
