package com.min.edu;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HappyController extends HttpServlet {

	private static final long serialVersionUID = -1670412454123466468L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET 요청됨");
		handleRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청됨");
		handleRequest(req, resp);
	}
	
	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("요청이 들어옴");
		System.out.println(request.getParameter("test"));
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			//1. 주소에서 정보를 추출  -> 추출된 정보로 실행되는 클레스 이름(String)을 만들고 Class.forName()-> 인스턴스로 만듬
			Handler handler = handlermapping(request);
			
			//2. 생선된 객체 공통 기능은 handle을 실행함
			String viewName = handlerAdapter(handler, request, response);
			System.out.println("이동하는 화면이름: " + viewName);
			
			// 3. 기능이 완료되면(HelloHandler -> dao -> 결과는 request scope에 담고 -> 이동할 문자열을 반환
			// 화면의  JSP가 있는 위치를 만들어 줌 => Helper View Patter => Resolver
			
			helperView(viewName, request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void helperView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		url = prefix + viewName + suffix;
		System.out.println("화면의 위치 JSP: " + url);
		
		//이동 흐름 방법 forward, redirect
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	private String handlerAdapter(Handler handler, HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// argument 객체에서(handler)에서 실행된 메소드를 reflection
		Method handleMethod = handler.getClass().getMethod("handle", HttpServletRequest.class, HttpServletResponse.class);
		//실행되라 invoke
		//실행된 화면의 이름을 준다고 했다 handle이
		return (String) handleMethod.invoke(handler, request, response);
	}

	private Handler handlermapping(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//요청받은 주소를 가져온다.
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		
		System.out.println("요청받은 uri 주소 : " + uri);
		System.out.println("요청받은 url 주소 : " + url) ;
		//path(uri)에서 끝에 마지막 단어를 추출한다. com.min.edu.~~~Handler  ex) com.min.edu.~~~Handler
		String handlerName = "com.min.edu." + 
								uri.substring(uri.lastIndexOf("/")+1) + 
								"Handler";
		System.out.println("호출할 클레스의 위치.이름 : " + handlerName);
		
		Class handlerClass = Class.forName(handlerName);
//		System.out.println(handlerClass.newInstance());
//		System.out.println(handlerClass.newInstance().getClass());
		
		return (Handler)handlerClass.newInstance();
		
	}

	
	
}
