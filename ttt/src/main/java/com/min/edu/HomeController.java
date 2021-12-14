package com.min.edu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home.do")
	public String home(Model model, String name) {
		
		model.addAttribute("val", name +"님 반갑습니다");
		
		return "/WEB-INF/views/home.jsp";
	}
}
