package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.dto.LoginDto;
import com.min.edu.model.ILoginService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ILoginService service;
	
	@RequestMapping(value = "/init.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(LoginDto dto) {
		logger.info("회원가입 입력 받은 값 {}", dto);
		
		int n = service.join(dto);
		System.out.println("&&&&회원가입 성공여부 " + n);
		
		return "home";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(LoginDto dto, HttpSession session) {
		logger.info("로그인 입력 받은 값 {}", dto);
		
		LoginDto lDto = service.login(dto);
		if(lDto != null) {
			session.setAttribute("ldto", lDto);
			System.out.println("&&&&로그인 성공 Session 값 " + session.getAttribute("ldto"));
		}else {
			System.out.println("&&&&로그인 실패");
			
		}
		
		return "home";
	}
	
}
