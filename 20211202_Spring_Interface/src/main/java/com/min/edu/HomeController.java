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
 * @Controller는 Spring Configuration.xml에 의해서 bean으로 자동등록된다 -> stereoType
 * 	=>servlet-context.xml <context:component-scan base-package="com.min.edu">선언되어 잇음
 * 
 * 요청되는 주소에서 실행하고자 하는 메소드를 찾아준다. => HandlerMapping
 * @RequestMapping, @GetMapping, @PostMapping을 통해서 해당 메소드와 매핑처리된다.
 * @RequestMapping(value="매핑이름",method="처리방식",produce="MIMEType")
 * 
 * Spring Container에 요청되는 주소에서 Adapter처리에 의해서 해당 메소드를 찾아서 실행
 * 요청(param)은 자동으로 HttpServletRequest에 자동으로 자바의 객체와 매핑된다.
 * 파싱(parsing) : String{"key","value"}
 * 바인딩(Binding) : EL. html에서 ${scope.변수} 이렇게 입력하면 깂이 입력된다. 값은 String타입
 * 
 * 화면의 흐름제어(RequestDispatcher, HttpServletResponse.sendRedirect)
 * String 전송이 되면 DispatcherServlet이 처리해준다. => Resolver<bean> -> 문자열리 BiewResolver에 의해서 화면의 위치를 찾아가게 해준다.
 *  => Helper View Pattern
 *  3-tier에서는 response.sendRedirect("주소")는 요청한 페이지의 주소창으로 보내지게 된다.
 *  4-tier(Spring Framework)은 자신의 Controller <bean>에서 RequestMapping을 찾는다.
 *  
 *  전송되는 값(stateless - MPA(Multiple page application)) : Scope 영역 객체에 담겨서 작동이 된다.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Value("${env.username}")
	private String envText;
	
	
	@Autowired
	private IService service;
	
	//@Get,PostMapping은 4.3.35 이상부터 가능 
	@RequestMapping(value = "/home.do", method = {RequestMethod.GET,RequestMethod.POST})
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
		logger.info("@GetMapping getHome에서 입력받은 값"+name);
		String str = "우리의 목표 :"+name;
		//값을 담는 방법
		//1. Scope에 담는다. : Parameter를 선언하여 사용해야한다.
		//2. ModelAndView 객체를 통해서 전달가능하다.
		model.addAttribute("str",str);
		
		//흐름제어 : ViewResolver가 없는 경우 직접적인 위치를 작성해야한다.
		//return "/WEB-INF/views/home.jsp"
		
		//ViewResolver가 있는 경우
		return "home"; //InternalResourceViewResolver가 prefix+값+suffix로 만들어서 전달한다.
	}
	
	@PostMapping(value="/getHome.do")
	public String getHome(EduVo vo, HttpServletRequest request) {
		logger.info("@PostMapping getHome에서 입력받은 title 값"+vo.getTitle());
		String str = "수업 과정 - "+vo;
		request.setAttribute("req_str", str);
		return "home";
	}
	
}
