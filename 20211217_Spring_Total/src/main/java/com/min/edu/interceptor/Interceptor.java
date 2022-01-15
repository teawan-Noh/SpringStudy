package com.min.edu.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Spring의
 * <mvc:interceptor를 통해서 특정한 RequestMapping전에
 * 실행되어 로직을 수행하고 결과에 따른 흐름제어가 가능
 * 로그인이 되어 있어야 호출되는 페이지를 Interceptor
 */
public class Interceptor extends HandlerInterceptorAdapter {
//이거는 시스템 구성이 다 끝난 후 해야한다.
   
   private Logger log = LoggerFactory.getLogger(this.getClass());
   
   
   
   //@Controller가 실행전 수행
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      log.info("eeeeee 인터셉터 시작");
      
      try {
         if(request.getSession().getAttribute("mem")==null) {
            response.sendRedirect("./logout.do");
            return false;
         }
      } catch (IOException e) {
         log.info("eeeeee 인터셉터 요청을 확인하세요");
         e.printStackTrace();
      }
      return super.preHandle(request, response, handler);
   }

   //@Controller가 실행후 수행되는 로직
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      log.info("eeeeee 인터셉터 종료");
      super.postHandle(request, response, handler, modelAndView);
   }

   //View 랜더링이 끝난 직후 수행
   //jsp가 랜더링이 될때
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      log.info("eeeeee View 랜더링이 끝난 후 수행");
      super.afterCompletion(request, response, handler, ex);
   }

   //비동기식 (@ResponseBody) 호출시 수행
   @Override
   public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      // TODO Auto-generated method stub
      super.afterConcurrentHandlingStarted(request, response, handler);
   }

}