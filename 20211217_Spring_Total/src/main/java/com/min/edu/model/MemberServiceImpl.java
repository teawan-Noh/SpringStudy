package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.Member_Dto;

@Service
public class MemberServiceImpl implements IMemberService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberDao dao;
	
	@Override
	public List<Member_Dto> memberList() {
		logger.info("MemberServiceImpl 회원전체 조회");
		return dao.memberList();
	}

	@Override
	public boolean signupMember(Member_Dto dto) {
		logger.info("MemberServiceImpl 회원가입 {}", dto);
		return dao.signupMember(dto);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		logger.info("MemberServiceImpl 아이디중복검사 {}" ,id);
		return dao.idDuplicateCheck(id);
	}

	@Override
	public Member_Dto loginMember(Map<String, Object> map) {
		logger.info("MemberServiceImpl 로그인 {}", map);
		return dao.loginMember(map);
	}

	@Override
	public String selStringPw(String id) {
		logger.info("MemberServiceImpl pw비교 {}", id);
		return dao.selStringPw(id);
	}

	@Override
	public Member_Dto enLogin(String id) {
		logger.info("MemberServiceImpl 시큘리티 로그인 {}", id);
		return dao.enLogin(id);
	}

	@Override
	public boolean chageUser(Map<String, Object> map) {
		logger.info("MemberServiceImpl 사용자 상태 변경 {}",map);
		return dao.chageUser(map);
	}

	
	
}
