package com.min.edu.bookctrl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("sessionAttribute_Test")
public class Session_01_Controller {
   
   private Logger logger = LoggerFactory.getLogger(this.getClass());
   
   @GetMapping(value="/sessionCreate.do")
   public String init(Model model, HttpSession session) {
      logger.info("Session_01_Controller 세션, @세션 값 입력");
      model.addAttribute("sessionAttribute_Test","@sessionAttribute");
      session.setAttribute("HttpSession_Test", "HttpSession");
      return "book/sessionCheck";
   }
   
   @GetMapping(value="/del01.do")
   public String test01(SessionStatus sessionStatus) {
      logger.info("Session_01_Controller @SessionAttribute를 삭제");
      sessionStatus.setComplete();
      return "book/sessionCheck";
   }
   
   @GetMapping(value="/del02.do")
   public String test02(HttpSession session) {
      logger.info("Session_01_Controller HttpSession을 삭제");
      session.invalidate();
      return "book/sessionCheck";
   }
}