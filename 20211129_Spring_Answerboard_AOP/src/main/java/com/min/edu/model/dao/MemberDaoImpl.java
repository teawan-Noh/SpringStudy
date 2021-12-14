package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.Member_VO;

@Repository
public class MemberDaoImpl implements IMemberDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.dao.MemberDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Member_VO getLogin(Map<String, Object> map) {
		logger.info("MemberDaoImpl 로그인 : " + map);
		return sqlSessionTemplate.selectOne(NS+"getLogin", map);
	}

	@Override
	public List<Member_VO> memberList() {
		logger.info("MemberDaoImpl 회원전체조회");
		return sqlSessionTemplate.selectList(NS+"memberList");
	}

	@Override
	public boolean signupMember(Member_VO vo) {
		logger.info("MemberDaoImpl 회원가입 : " + vo);
		int cnt = sqlSessionTemplate.insert(NS+"signupMember", vo);
		return (cnt > 0) ? true : false;
	}

	@Override
	public boolean idDuplicateCheck(String checkId) {
		logger.info("MemberDaoImpl 아이디 중복체크 : " + checkId);
		int cnt = sqlSessionTemplate.selectOne(NS+"idDuplicateCheck", checkId);
		return (cnt > 0) ? true : false;
	}

	@Override
	public Member_VO loginMember(Map<String, Object> map) {
		logger.info("MemberDaoImpl 사용중인 회원 : " + map);
		return sqlSessionTemplate.selectOne(NS+"loginMember", map);
	}

	@Override
	public String selStringPW(String id) {
		logger.info("MemberDaoImpl 패스워드 조회 : " + id);
		return sqlSessionTemplate.selectOne(NS+"selStringPW", id);
	}

	@Override
	public Member_VO enterLogin(String id) {
		logger.info("MemberDaoImpl 아이디로 정보 조회 로그인 : " + id);
		return sqlSessionTemplate.selectOne(NS+"enterLogin", id);
	}

	@Override
	public boolean ChangeUser(Map<String, Object> map) {
		logger.info("MemberDaoImpl 사용자 상태정보 변경 : " + map);
		int cnt = sqlSessionTemplate.update(NS+"ChangeUser", map);
		return (cnt > 0) ? true : false;
	}

}
