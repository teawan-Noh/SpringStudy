package com.min.edu;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.IService;
import com.min.edu.vo.EduVo;

/*
 * @Controller는 Spring Configuration.xml에 의해서 bean으로 자동 등록됨 => stereotype
 * servlet-context.xml <context:component-scan base-package="com.min.edu"> 선언되어 있음
 * 
 * 요청되는 주소에서 실행하고자 하는 메소드를 찾아줌 => handlerMapping
 * @RequestMapping 혹은 @GetMapping, @PostMapping 을 통해서 해당 메소드와 매핑처리됨
 * @RequestMapping("매핑 이름", method 처리방식, produce="MIMEType")
 * 
 * Spring Container에 요청되는 주소에서 Adapter처리에 의해서 해당 메소드를 찾아서 실행
 * 요청(param)은 자동으로 HttpServletRequest에 자동으로 자바의 객체와 매핑
 * 파싱(parsing) : String("key","value"}
 * 바인딩(binding) : EL html ${scope.변수} 값이 입력
 * 
 * 화면의 흐름제어(RequestDispatcher, HttpServletResponse sendRedirect)
 *   String 전송되면 Dispatcher Servlet이 처리해줌 -> Resolver<bean> -> 문자열이 ViewResolver에 의해서 화면의 위치를 찾아가게 해줌
 *   =>Helper View Pattern
 *   ** 3-tier 에서는 response.sendRedirect("주소")는 요청한 페이지의 주소창으로 보내지게 됨.
 *      4-tier(Spring Framework)은 자신의 Controller <bean>에서 RequestMapping을 찾는다
 *      
 * 전송되는 값(stateless - MPA(multiple page application)) : Scope 영역 객체에 담겨서 작동이 됨.
 * 
 */
@Controller
public class HomeController {
	
	@Autowired
	private IService service;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${env.username}")
	private String envText;
	
	@RequestMapping(value = "/home.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("envText",envText);
		return "home";
	}
	
	@GetMapping(value="/getHome.do")
	public String getHome(String name, Model model) {
		logger.info("@GetMapping getHome에서 입력받은 name 값" + name);
		String str = "우리의 목표 : "+ name;
		//값을 담는 방법
		// 1)Scope 담는다 - parameter를 선언하여 사용해야 함.
		// 2)ModelAndView 객체를 통해서도 전달이 가능하다.
		model.addAttribute("str",str);
		//흐름제어 : ViewResolver가 없는 경우 직접적인 위치를 작성
		//return "/WEB-INF/views/home.jsp"
		return "home"; //InternalResourceViewResolver가 prefix+값+suffix로 만들어 전달
		
	}
	
	@PostMapping(value="/getHome.do")
	public String getHome(EduVo vo, HttpServletRequest request) {
		logger.info("@GetMapping getHome에서 입력받은 title 값" + vo.getTitle());
		String str = "수업 과정 - "+ vo;
		request.setAttribute("req_str", str);
		return "home";
	}
}
