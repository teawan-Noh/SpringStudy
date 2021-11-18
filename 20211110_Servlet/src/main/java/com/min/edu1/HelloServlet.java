package com.min.edu1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 2321330082918882278L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		//web.xml에 있는 initial 값인 init-param
		String webInt = getServletConfig().getInitParameter("webInit");
		
		//web.xml에 있는 comtext-param
		String winter = getServletContext().getInitParameter("winter");
		
		String address = req.getParameter("address");
		String html = "<html><head><title>HelloServlet2.X</title></head>"
				+ "<body>"
				+ address + webInt + winter
				+ "</body></html>";
		
		resp.getWriter().println(html);
		//화면 onclick => helloServlet.do -> com.min.edu1.HelloServlet.java -> doGet-> ~ -> printWriter 화면출력
	}
}
