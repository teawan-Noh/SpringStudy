package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.service.IMemberService;
import com.min.edu.vo.Member_VO;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberService service;
	
	@GetMapping("/loginForm.do")
	public String loginForm() {
		logger.info("MemberController 로그인폼으로 이동");
		
		return "loginForm";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map, HttpSession session) {
		logger.info("MemberController 로그인 전달값 : " + map.get("id"));
		logger.info("MemberController 로그인 전달값 : " + map.get("pw"));
		
		Member_VO vo = service.getLogin(map);
		session.setAttribute("lvo", vo);
		System.out.println(vo + "vo 받아오는지 체크");
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm.do";
	}
	
	@GetMapping("/signupForm.do")
	public String signupForm() {
		logger.info("회원가입 폼으로 이동");
		return "signupForm";
	}
	
	@GetMapping("/duplication.do")
	public String duplication() {
		logger.info("아이디 중복 검사 이동");
		return "duplication";
	}
	@RequestMapping(value="/signup.do", method= RequestMethod.POST)
	public String signup(Member_VO vo, HttpServletResponse resp) throws IOException {
		
		logger.info("회원가입");
		boolean isc = service.signupMember(vo);
		if(isc) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입을 축하합니다');</script>");
			out.flush();
			return "loginForm";
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입에 실패하셨습니다');</script>");
			out.flush();
			
			return "loginForm";
		}
		
	}
}
