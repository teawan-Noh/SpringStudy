package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.vo.BoardVo;

public class AjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json; charset=UTF-8");
		
		IBoardDao dao = new BoardDaoImpl();
		BoardVo vo = dao.selectOneBoard("1");
		
		JSONObject obj = new JSONObject();
		obj.put("seq", vo.getSeq());
		obj.put("title", vo.getTitle());
		obj.put("content", vo.getContent());
		obj.put("regdate", vo.getRegdate());
		
		PrintWriter out = resp.getWriter();
		out.print(obj);
		
		out.flush();
		out.close();
	}
}
