package com.min.edu.bookctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.min.edu.model.IUserService;
import com.min.edu.vo.UserVo;

@Controller
@SessionAttributes("loginVo") // session 객체이면서 현재 사용하고 있는 Controller에서만 사용이 가능하다.
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService service;
	/*
	 * mybatis에서의 조회는 selectList(), selectOne();
	 * selectOne은 반환되는 resultType으로 casting되어 반환됨, 만약 실행된 쿼리의 결과가 없다면(공집합) 객체가 생성되지 않은 상태(null)로 반환됨
	 * selectList는 반환되는 resultType으로 Generic이 구성된 JCF인 List<T>로 반환 됨, 실행결과가 공집합이라면 객체의 size가 0이 됨
	 * 그러므로 selectOne이라면 null 확인, selectList라면 size=0 확인
	 */
	
	/*
	 * (scope는 page, request, session, application)
	 * 로그인 후에 @SessionAttribute에 담아서 다른 Mapping에서 사용할 때 HttpSession을 선언하지 않고 사용
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVo vo, Model model) {
		logger.info("LoginController @SessionAttributes 사용 {}", vo);
		
		UserVo loginVo = service.login(vo);
		//login()메소드는 selectOne으로 실행했기 때문에 null 판별이 필요하다
		if(loginVo == null) {
			return "redirect:/book/home.do";
		}else {
			logger.info("$$$$$ 로그인 값{}", loginVo);
			model.addAttribute("loginVo", loginVo);
			return "book/BoardList";
		}
	}
	
	//Model에 담는 법
//	@RequestMapping(value="/login.do", method = RequestMethod.POST)
//	public String login(Model model,@ModelAttribute("userdto") UserVo vo) {
//		//model.addAttribute() == @ModelAttribute
//		/*
//		 * 값을 전달하는 방식
//		 * view에서 전달(POST 필수 form요소 name 혹은 GET 방식은 QueryString) => Parameter => String으로 전달 받음
//		 * name이 없다면 null, name만 존재 한다면 "", name=값 이면 값을 전달받음
//		 * HttpServletRequest request.getParameter("name") => String으로 가져옴
//		 * 
//		 * view => Controller forwead => view에서도 값을 전송 받을 수 있다.
//		 * 
//		 * 하지만 결과가 Object(POJO, DTO, JCF)를 반환한다면 Scope 객체를 통해서 전달해야한다
//		 * request.setAttribute("key", value); => view => ${key} or <% $> (스크립틀릿)으로 전달 받음
//		 * 
//		 * @Spring은 전달 받은 parameter를 자동으로 set을 호출하여 name과 같은 set에 실행을 통해서 객체로 자동으로 만들어줌
//		 * @ModerAttribute를 사용하면 자동으로 Model의 객체에 담아준다.
//		 * 따라서 다시 model.addAttribute를 통해서 값을 저장하지 않아도 된다.
//		 * 
//		 */
//		
//		return "book/modelattr";
//	}
	
	@RequestMapping(value = "/registForm1.do", method = RequestMethod.GET)
	public String registForm1() {
		logger.info("registForm1 회원가입 registForm1()"); 
		
		return "book/registForm";  //무조건 resolver 처리가 되기 떄문에 /WEB-INF/views/
	}
	
	@RequestMapping(value = "/duplication.do", method = RequestMethod.GET)
	public String duplication() {
		
		return "book/duplication";
	}
	
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus, @ModelAttribute("loginVo") UserVo vo) {
		/*
		 * Model 객체는 request scope 영역이다. 하지만 session scope를 사용하기 위해서는
		 * @Controller에 @SessionAttribute("사용이름@")을 설정하고
		 *  @SessionAttribute에 값을 입력을 할 떄는 ui.Model을 사용하여 model.addAttribute("사용이름@", 값)을 하면 
		 *  실행되는 model은 request scope가 아닌 session scope에 담기게 됨
		 *  
		 *  호출할 떄는 HttpSession을 통해서 사용이 가능함 
		 *  	ex) HttpSession session.getAttribute("사용이름@") => Object로 반환되기 때문에 Casting을 사용해야 하고
		 *  	  public String 메소드명 (@ModelAttribute("사용이름@") 타입 vo){..} => 자동으로 객체를 변환하여 casting없이 사용할 수 있다.
		 */
		logger.info("LoginController logout @SessionAttribute {}", vo);
		/*
		 * 로그아웃의 기능은 사용되고 있는 session의 값을 삭제 하거나 아니면 session의 객체를 unbind 시키는 것
		 * 	값을 삭제: session.removeAttribute("사용이름@") => 객체는 있지만 객체안의 "사용이름@"이라는 이름의 row를 삭제하는것을 말함
		 * 		  : session.invalidate() => 사용되고 있는 HttpSession의 객체를 unbind 즉 null로 만들어준다
		 * 
		 * @SessionAttribute를 삭제하고 싶다면 HttpSession의 session.invalidate()가 아닌
		 *  SessionStatus sessionStatus의 sessionStatus.setComplete()를 통해서 cleanup 할 수 있다.
		 */
		//1.invalidate를 통해서 객체의 변화 => getAttribute: 세션이 이미 무효화되었습니다.
//		session.invalidate();
//		UserVo uvo = (UserVo)session.getAttribute("loginVo");
		
		//2.removeAttribute를 통한 객체의 변화 => session은 존재하지만 요청한 key의 값이 없기 때문에 없음
//		session.removeAttribute("loginVo");
//		UserVo uvo = (UserVo)session.getAttribute("loginVo");
		
		//3, setComplete은 cleanup 해준다
		sessionStatus.setComplete();
		UserVo uvo = (UserVo)session.getAttribute("loginVo");
		
		
		logger.info("삭제된 uvo", uvo);
		
		return null;
		
	}
}

