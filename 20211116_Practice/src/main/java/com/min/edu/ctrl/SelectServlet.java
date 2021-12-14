package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.vo.BoardVo;

public class SelectServlet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private IBoardDao dao = new BoardDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("전체조회");
		List<BoardVo> lists = dao.selectAllBoard();
		logger.info("Dao실행 selectAllBoard");
		req.setAttribute("lists", lists);
		forward(req, resp, "/WEB-INF/views/boardList.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("단일조회");
		String seq = req.getParameter("seq");
		BoardVo vo = dao.selectOneBoard(seq);
		req.setAttribute("vo", vo);
		forward(req, resp, "/WEB-INF/views/boardList.jsp");
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
		
	}
	
}
