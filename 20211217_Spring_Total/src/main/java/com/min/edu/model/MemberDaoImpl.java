package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.Member_Dto;

@Repository
public class MemberDaoImpl implements IMemberDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.IMemberDao.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Member_Dto> memberList() {
		return sqlSession.selectList(NS+"memberList");
	}

	@Override
	public boolean signupMember(Member_Dto dto) {
		String enPassword = passwordEncoder.encode(dto.getPw());
		dto.setPw(enPassword);
		int n = sqlSession.insert(NS+"signupMember", dto);
		return n>0?true:false;
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int n = sqlSession.selectOne(NS+"idDuplicateCheck", id);
		return n>0?true:false;
	}

	@Override
	public Member_Dto loginMember(Map<String, Object> map) {
		String dbPw = sqlSession.selectOne(NS+"selStringPw", map.get("id"));
		Member_Dto dto = null;
		
		if(passwordEncoder.matches((String)map.get("pw"), dbPw)) {
			dto = sqlSession.selectOne(NS+"enLogin", map.get("id"));
		}
		return dto;
	}

	@Override
	public String selStringPw(String id) {
		return sqlSession.selectOne(NS+"selStringPw", id);
	}

	@Override
	public Member_Dto enLogin(String id) {
		return sqlSession.selectOne(NS+"enLogin", id);
	}

	@Override
	public boolean chageUser(Map<String, Object> map) {
		int n = sqlSession.update(NS+"chageUser", map);
		return n>0?true:false;
	}

}
