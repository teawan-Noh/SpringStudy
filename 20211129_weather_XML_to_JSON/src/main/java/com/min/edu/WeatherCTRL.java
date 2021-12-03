package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeatherCTRL extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8;");
		
		System.out.println("weatherCTRL POST 요청됨");
		String code = req.getParameter("zone");
		System.out.println("전달 요청값: " + code);
		
//		PrintWriter out = resp.getWriter();
//		out.print("전송데이터");
//		out.print("{\"data\":\"value\"}");
		
		req.setAttribute("code", code);
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/weatherInfo.jsp");
		dispatcher.forward(req, resp);
	}
}
