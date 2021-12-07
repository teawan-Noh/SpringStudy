package com.min.edu.bookctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.vo.UserVo;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("userdto") UserVo vo) {
		
		return "book/modelattr";
	}
}
