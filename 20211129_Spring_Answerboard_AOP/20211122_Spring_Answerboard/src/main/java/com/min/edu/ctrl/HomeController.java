package com.min.edu.ctrl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/init.do") // 5버전 이상용
//	@RequestMapping(value="/init.do", method = RequestMethod.GET) // 구버전용
	public String init(Model model, String name) {
		logger.info("처음시작하는 Spring{}", new Date());
		model.addAttribute("val", name +"님 반갑습니다");
		return "init";
	}
}
