package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.dao.IMemberDao;
import com.min.edu.vo.Member_VO;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private IMemberDao dao;
	
	@Override
	public Member_VO getLogin(Map<String, Object> map) {
		return dao.getLogin(map);
	}

	@Override
	public List<Member_VO> memberList() {
		return dao.memberList();
	}

	@Override
	public boolean signupMember(Member_VO vo) {
		return dao.signupMember(vo);
	}

	@Override
	public boolean idDuplicateCheck(String checkId) {
		return dao.idDuplicateCheck(checkId);
	}

	@Override
	public Member_VO loginMember(Map<String, Object> map) {
		return dao.loginMember(map);
	}

	@Override
	public String selStringPW(String id) {
		return dao.selStringPW(id);
	}

	@Override
	public Member_VO enterLogin(String id) {
		return dao.enterLogin(id);
	}

	@Override
	public boolean ChangeUser(Map<String, Object> map) {
		return dao.ChangeUser(map);
	}

}
