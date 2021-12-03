package com.min.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/StudentCal.do")
public class StudentScoreCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ajax를 통해서 값을 받고
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math =Integer.parseInt(request.getParameter("math"));
		
		System.out.printf("요청값은 파라미터 : %s %d %d %d", name,kor,eng,math);
		
		int sum = kor+eng+math;
		double avg = sum/3.0;
		
		//값을 JSON 형태로 담아줌
		//1번 무식이
//		StringBuffer sb = new StringBuffer();
//		sb.append("{");
//		
//		sb.append("\"name\"");
//		sb.append(":");
//		sb.append("\""+name+"\"");
//		sb.append(",");
//		
//		sb.append("\"sum\"");
//		sb.append(":");
//		sb.append("\""+sum+"\"");
//		sb.append(",");
//		
//		sb.append("\"avg\"");
//		sb.append(":");
//		sb.append("\""+avg+"\"");
//		
//		sb.append("}");
//		
//		System.out.println("반환되는 결과 값 JSON"+sb.toString());
//		PrintWriter out = response.getWriter();
//		out.println(sb.toString());
		//2번 똑똑이
		JSONObject jsonO = new JSONObject();  
		jsonO.put("name", name);
		jsonO.put("sum", sum);
		jsonO.put("avg", avg);
		
		response.getWriter().println(jsonO.toJSONString());
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math =Integer.parseInt(request.getParameter("math"));
		
		System.out.printf("요청값은 파라미터 : %s %d %d %d", name,kor,eng,math);
		
		int sum = kor+eng+math;
		double avg = sum/3.0;
		
		JSONObject jsonO = new JSONObject();  
		jsonO.put("name", name);
		jsonO.put("sum", sum);
		jsonO.put("avg", avg);
		
		response.getWriter().println(jsonO.toJSONString());
	}

}
