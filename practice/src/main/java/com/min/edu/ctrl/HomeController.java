package com.min.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/init.do")
	public String init(Model model, String name) {
		logger.info("연습중 입니다 {}", name);
		model.addAttribute("val", name +"님 반갑습니다");
		
		return "init";
	}
}
