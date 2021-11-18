package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;

public class DeleteServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(this.getClass());
	private IBoardDao dao = new BoardDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("DeleteServlet GET");
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		int cnt = dao.deleteBoard(seq);
		resp.sendRedirect("./selectBoard.do");
	}
}
