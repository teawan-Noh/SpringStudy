package com.min.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse resp) {
		//dao를 연결해서 처리
		String name = req.getParameter("name");
		
		//JSP에 값을 전송하는 Scope(request scope를 사용)
		req.setAttribute("val", name + "우리의 이름이다");
		
		//기능을 처리하고 이동할 화면의 이름
		return "hello";
	}

}
