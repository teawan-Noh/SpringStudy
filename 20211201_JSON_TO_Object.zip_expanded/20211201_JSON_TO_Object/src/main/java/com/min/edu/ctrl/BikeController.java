package com.min.edu.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.min.edu.dao.BikeDaoImpl;
import com.min.edu.dao.IBikeDao;
import com.min.edu.dto.BikeDto;

@WebServlet("/bikeController.do")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String command = request.getParameter("command");
		System.out.println("요청받은 분기값: "+ command);
		
		if(command.equalsIgnoreCase("first")) {
			response.sendRedirect("./bikeView01.jsp");
		}else if(command.equalsIgnoreCase("second")) {
			response.sendRedirect("./bikeView02.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		
		String command = request.getParameter("command");
		System.out.println("POST 요청받은 분기값: "+ command);
		
		IBikeDao dao = new BikeDaoImpl();
		
		if(command.equalsIgnoreCase("first_db")) {
			String[] bikeList = request.getParameterValues("bike");
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			for (int i = 0; i < bikeList.length; i++) {
				String[] tmp = bikeList[i].split("/");
				System.out.println(Arrays.toString(tmp));
				int idx = 0;
				BikeDto d = 
						new BikeDto(tmp[idx++],
									Integer.parseInt(tmp[idx++])	,
									tmp[idx++],
									Double.parseDouble(tmp[idx++]) ,
									Integer.parseInt(tmp[idx++]),
									Double.parseDouble(tmp[idx++]),
									tmp[idx++]);
				dtos.add(d);
			}
			
			dao.bikeDelete();
			
			int n = dao.bikeInsert(dtos);
			System.out.println("입력된 자전거 대여소의 갯수 : "+ n);
			
			if(n>0) {
				System.out.println("DB에 저장되었습니다");
			}else {
				System.out.println("DB에 저장을 실패했습니다");
			}
		}else if(command.equalsIgnoreCase("second_db")) {
			String jsonObj = request.getParameter("obj");
			System.out.println("ajax전달받은 JSON test \n" + jsonObj);
			
			List<BikeDto> dtos = new ArrayList<BikeDto>();
			
			JsonParser parse = new JsonParser();
			
			JsonElement element = parse.parse(jsonObj);
			
			int dataCNT = element.getAsJsonObject().get("DATA").getAsJsonArray().size();
//			System.out.println("DATA 키의 값의 개수: " + dataCNT);
//			
//			JsonElement ele = element.getAsJsonObject().get("DATA")
//							  .getAsJsonArray().get(0)
//							  .getAsJsonObject()
//							  .get("NEW_ADDR");
//			
//			System.out.println("DATA의 첫번쨰 NEW_ADDR 값: " + ele.getAsString());
			
			for (int i = 0; i < dataCNT; i++) {
				JsonObject temp = element.getAsJsonObject().get("DATA")
										 .getAsJsonArray().get(i)
										 .getAsJsonObject();
				JsonElement a1 = temp.get("NEW_ADDR");
				JsonElement a2 = temp.get("CONTENT_ID");
				JsonElement a3 = temp.get("ADDR_GU");
				JsonElement a4 = temp.get("LONGITUDE");
				JsonElement a5 = temp.get("CRADLE_COUNT");
				JsonElement a6 = temp.get("LATITUDE");
				JsonElement a7 = temp.get("CONTENT_NM");
				
				BikeDto dto = 
						new BikeDto(a1.getAsString(), 
								a2.getAsInt(), 
								a3.getAsString(), 
								a4.getAsDouble(), 
								a5.getAsInt(), 
								a6.getAsDouble(), 
								a7.getAsString());
				dtos.add(dto);
			}
			dao.bikeDelete();
			
			int n = dao.bikeInsert(dtos);
			if(n>0) {
				System.out.println("DB에 성공적으로 입력");
			}else {
				System.out.println("DB에 입력 실패");
			}
			
			response.getWriter().println(n);
		}
	}
}




