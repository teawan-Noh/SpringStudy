package com.min.edu.bookctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.IUserService;
import com.min.edu.vo.UserVo;

@Controller
public class ValidationController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	
	@ModelAttribute("memvervo")
	public UserVo modelAttribute() {
		UserVo vo = new UserVo();
		
		return vo;
	}
	
	@RequestMapping(value="/regist.do", method = RequestMethod.POST)
	public String registReference(UserVo vo, HttpServletResponse response) throws IOException {
		logger.info("ValidationController 회원가입 일반 {}", vo);
		String result = service.regist(vo);
		logger.info("ValidationController 회원가입 완료 {}", result);
		
		if(result == null) {
			return "redirect:/book/home.do";
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('성공적으로 입력되었습니다'); location.href='./book/home.do'</script>");
			out.flush();
			return null; //redirect는 사용하지 말라했음 
		}
	}
	
	/*
	 * validate 객체를 전달하기 위해 ModelAttribute로 생선된 객체를 미리 전달
	 * 30번째 줄의 메소드 주입과 같은 형태를 가진다
	 */
	@RequestMapping(value="/registForm2.do", method = RequestMethod.GET)
	public String registForm2(@ModelAttribute("vo") UserVo vo) {
		logger.info("ValidationController registForm2");
		return "/book/registForm2";
	}
	@RequestMapping(value = "/regist2.do", method = RequestMethod.POST)
	public String regist2(@ModelAttribute("memvervo") @Valid UserVo uservo, BindingResult result, HttpServletResponse resp) throws IOException {
		logger.info("ValidationController regist2");
		if(result.hasErrors()) {
			System.out.println("실패후 validate");
			return "/book/registForm2";
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('성공적으로 입력되었습니다'); location.href='./book/home.do'</script>");
			out.flush();
			
			return null;
		}
		
	}
	
	
}
