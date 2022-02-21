package com.min.edu.bookctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{book}/")
public class Home2Controller {
//com.min.edu에서 HomeController.java와 @Controller로 인해서 만들어지는 Bean의 이름이 같아서 에러가 났다!
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/home.do")
	private String home(@PathVariable("book") String path) {
		return path+"/home";
	}
}
