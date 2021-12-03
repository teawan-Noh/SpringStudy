package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.All_Dto;
import com.min.edu.dto.Player_Dto2;
import com.min.edu.dto.Team_Dto;
import com.min.edu.dto.Team_Dto3;
import com.min.edu.model.FootBallDaoImpl;
import com.min.edu.model.IFootBallDao;

public class MyBatisJoinCtrl extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		System.out.println("MyBatisJoinCtrl");
		
		IFootBallDao dao = new FootBallDaoImpl();
		
		List<All_Dto> lists = dao.combine1();
		req.setAttribute("lists", lists);
		
		List<Team_Dto> listsT = dao.combine2();
		req.setAttribute("listsT", listsT);
		
		List<Team_Dto> listsC = dao.combine3();
		req.setAttribute("listsC", listsC);
		
		List<Player_Dto2> listsCC = dao.combine4();
		req.setAttribute("listsCC", listsCC);
		
		List<Team_Dto3> listsCL = dao.combine5();
		req.setAttribute("listsCL", listsCL);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
