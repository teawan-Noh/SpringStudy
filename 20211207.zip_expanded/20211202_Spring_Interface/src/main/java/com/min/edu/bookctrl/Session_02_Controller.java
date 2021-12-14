package com.min.edu.bookctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class Session_02_Controller {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@GetMapping(value = "/del03.do")
	public String test03(SessionStatus sessionStatus) {
		logger.info("Session_02_Controller @SessionAttribute 삭제");
		sessionStatus.setComplete();
		
		return "book/sessionCheck";
	}
	
	@GetMapping(value = "/del04.do")
	public String test04(HttpSession session) {
		logger.info("Session_02_Controller HttpSession 삭제");
		session.invalidate();
		
		return "book/sessionCheck";
	}
}
