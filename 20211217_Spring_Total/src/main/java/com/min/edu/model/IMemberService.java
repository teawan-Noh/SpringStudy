package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Member_Dto;

public interface IMemberService {


//	회원전체 조회	memberList
	public List<Member_Dto> memberList();
//	회원가입	signupMember
	public boolean signupMember(Member_Dto dto);
	
//	아이디중복검사	idDuplicateCheck
	public boolean idDuplicateCheck(String id);
	
//	로그인	loginMember
	public Member_Dto loginMember(Map<String, Object> map);
	
//	PW 비교	selStringPw
	public String selStringPw(String id);
	
//	Security Login	enLogin
	public Member_Dto enLogin(String id);
	
//	사용자 상태 변경	chageUser
	public boolean chageUser(Map<String, Object> map);
}
