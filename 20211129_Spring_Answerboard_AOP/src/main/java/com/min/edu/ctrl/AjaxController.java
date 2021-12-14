package com.min.edu.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.min.edu.model.service.IMemberService;

@RestController
public class AjaxController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IMemberService service;
	
	@PostMapping("/duplicationAjax.do")
	public String duplicationAjax(String checkId) {
		logger.info("Rest Controller 아이디 중복검사");
		boolean isc = service.idDuplicateCheck(checkId);
		
		return String.valueOf(isc);
	}
}
