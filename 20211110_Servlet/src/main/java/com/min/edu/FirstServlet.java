package com.min.edu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet.do")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("firstServlet init()");
	}

	public void destroy() {
		System.out.println("firstServlet destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter   http://localhost:8096/Test?name=hong
		String name = request.getParameter("name");
		System.out.println("firstServlet 값" + name);
		
//		String htmlResult = "<h1>Hello world</h1>";
//		response.getWriter().print(htmlResult);
		
		//흐름제어
		//forward redirect
//		RequestDispatcher dispatcher = request.getRequestDispatcher("secondServlet.do");
//		dispatcher.forward(request, response);
		
		response.sendRedirect("secondServlet.do");
	}

}
