package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.dto.Member_Dto;
import com.min.edu.model.IMemberService;

@Controller
@SessionAttributes("mem2")
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberService service;
	
	//TODO 001. 로그인 화면으로 이동
	@GetMapping(value = "/loginForm.do")
	public String loginForm() {
		logger.info("MemberController 로그인 화면 이동");
		return "loginForm";
	}
	
	//TODO 002. 로그인 화면에서 Ajax로 로그인 정보 확인 Text 반환처리
	@PostMapping(value = "/loginCheckText.do" , produces = "application/text; charset=UTF-8;")
	@ResponseBody
	public String loginCheckText(String id, String pw) {
		logger.info("loginCheckText.do {}", id);
		logger.info("loginCheckText.do {}", pw);
		return "성공";
	}
	
	//TODO 003. 로그인 화면에서 Ajax로 로그인 정보 확인 Map -> jackson JSON 반환처리
	
	@PostMapping(value = "/loginCheckMap.do")
	@ResponseBody
	public Map<String, String> loginCheckMap(@RequestParam Map<String, Object> iMap){
		Map<String, String> map = new HashMap<String, String>();
		Member_Dto mDto = service.loginMember(iMap);
		logger.info("MemberController loginCheckMap 로그인된 값 {}" , mDto);
		if(mDto == null) {
			map.put("isc", "실패");
		}else {
			map.put("isc", "성공");
		}
		return map;
	}
	
	// TODO 004. Ajax확인 후 로그인 진행 HttpSession, @SessionAttribute 확인
	@PostMapping(value = "/login.do")
	public String login(@RequestParam Map<String, Object> map, HttpSession session,
																Model model) {
		logger.info("MemberController login {}", map);
		Member_Dto mDto = service.loginMember(map);
		model.addAttribute("mem2", mDto); // 같은 Controller에서 SessionStatus()
		session.setAttribute("mem", mDto); // invalidate();
		return "redirect:/boardList.do";
	}
	
	//TODO 006. 로그아웃 @SessionAttribute(mem2), HttpSession(mem) 두개를 설정 함
	@GetMapping(value = "/logout.do")
	public String logout(HttpSession session, //@ModelAttribute("mem2") Member_Dto dto, 
											  SessionStatus sessionStatus) {
		//logger.info("MemberController @SessionAttibute {}",dto);
		logger.info("MemberController HttpSession {}", (Member_Dto)session.getAttribute("mem"));
		
		// 같은 컨트롤러일때는 각각 삭제 해줘야하며, 다른 컨드롤러 일때는 session을 삭제
		session.invalidate();
		sessionStatus.setComplete();
		
		return "redirect:/loginForm.do";
	}
	
	
	//TODO 007. 회원가입
	@GetMapping(value = "/signupForm.do")
	public String signupForm() {
		logger.info("MemberController 회원가입 화면");
		return "signupForm";
	}
	
	//TODO 008. 회원가입시 ID이 중복 체크
	@PostMapping(value = "/idCheck.do")
	@ResponseBody
	public Map<String, String> idCheck(String id){
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.idDuplicateCheck(id); // false면 중복된 아니디가 아니다
		map.put("isc", String.valueOf(isc));
		return map;
	}
	
	//TODO 009. 회원가입 정보 입력
	@PostMapping(value = "/signup.do")
	public String signup(Member_Dto dto) {
		logger.info("MemberController 회원가입 정보 입력 {}",dto);
		boolean isc = service.signupMember(dto);
		return isc ? "redirect:/loginForm.do": "redirect:/signupForm.do";
	}
	
	//TODO 010. 관리자가 회원의 전체 정보를 조회하는 기능
	@GetMapping(value = "/memberListMAV.do")
	public ModelAndView memberListMAV() {
		logger.info("MemberController 회원 전체 조회 ");
		
		List<Member_Dto> mLists = service.memberList();
		
		ModelAndView mav = new ModelAndView();
		// ModelAndView 객체는 Model(request전달값) + View(화면 이동 문자) => DispacherServlet 으로 이동
		mav.setViewName("memberList");
		mav.addObject("mList", mLists);
		
		return mav;
	}
	
}













