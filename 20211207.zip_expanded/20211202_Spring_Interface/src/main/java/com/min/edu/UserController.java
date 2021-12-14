package com.min.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	
	@GetMapping(value="/home.do")
	public String userTest() {
		System.out.println("Welcome UserController userTest");
		return null;
	}
}
