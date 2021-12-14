package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.vo.BoardVo;

public class InsertServlet extends HttpServlet {

		private Logger logger = Logger.getLogger(this.getClass());
		private IBoardDao dao = new BoardDaoImpl();
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			logger.info("InsertServlet POST 호출");
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			int cnt = dao.insertBoard(new BoardVo(title, content));
			System.out.println(cnt>0?"성공":"실패");
			resp.sendRedirect("./selectBoard.do");
		}
		
}
