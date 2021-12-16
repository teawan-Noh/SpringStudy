package com.min.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketController {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@GetMapping(value = "/socketOpen.do")
	public String socketOpen() {
		logger.info("세상의 참여하는 모든사람과 채팅을 해보자");
		return "socket";
	}
}
