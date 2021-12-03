package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.Member_VO;
/**
 * 사용자 기능 인터페이스
 * @author taewan Noh
 * @since 2021. 11. 25.
 * @version 1b
 */
public interface IMemberService {

//	로그인 getLogin
	/**
	 * 사용자/관리자가 로그인을 하는 기능
	 * @param 아이디/ 패스워드
	 * @return 로그인 정보
	 */
	public Member_VO getLogin(Map<String, Object> map);
	
//	회원전체조회 memberList
	/**
	 * 관리자가 전체회원에 대한 조회를 하는 기능
	 * @return 가입된 회원 정보
	 */
	public List<Member_VO> memberList();
	
//	회원가입 signupMember
	/**
	 * 신규 회원가입 기능
	 * @param 회원가입(아이디, 비밀번호, 이름)
	 * @return 가입 성공확인 (true/false)
	 */
	public boolean signupMember(Member_VO vo);
	
//	아이디중복체크 idDuplicateCheck
	/**
	 * 회원가입시 아이디 사용여부
	 * @param 확인 아이디
	 * @return 사용가능 여부 (true/false)
	 */
	public boolean idDuplicateCheck(String checkId);
	
//	회원전체(사용중)조회 loginMember
	/**
	 * 회원 중 사용가능 여부 컬럼(DelFlag)를 확인
	 * @param 회원정보(아이디, 비밀번호)
	 * @return 회원정보 중 Delflag가 N인 사용자
	 */
	public Member_VO loginMember(Map<String, Object> map);
	
//	패스워드 조회 selStringPW
	/**
	 * 패스워드 변경 및 분실시 확인 기능
	 * @param 아이디
	 * @return 아이디에 상용하는 비밀번호
	 */
	public String selStringPW(String id);
	
//	아이디로 정보 조회 로그인 enterLogin
	/**
	 * 아이디를 통해 회원정보 조회 기능
	 * @param 아이디
	 * @return 회원정보
	 */
	public Member_VO enterLogin(String id);
	
//	사용자 상태정보 변경 ChangeUser
	/**
	 * 사용자 계정의 사용/비사용 기능 변경
	 * @param 변경정보, 변경아이디
	 * @return 변경 성공(true/false)
	 */
	public boolean ChangeUser(Map<String, Object> map);
}
