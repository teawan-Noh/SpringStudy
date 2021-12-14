package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.vo.BoardVo;

public class ModifyServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(this.getClass());
	private IBoardDao dao = new BoardDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("ModifyServlet POST");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		String newContent = content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
		System.out.printf("%s / %s", seq, content);
		System.out.printf("%s / %s", seq, newContent);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seqmap", seq);
		map.put("contentmap", content);
		
		int cnt = dao.modifyBoard(map);
//		System.out.println(cnt>0?"성공":"실패");
		
		if(cnt>0) {
			BoardVo vo = dao.selectOneBoard(seq);
			String contentDB = vo.getContent();
			contentDB.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			vo.setContent(contentDB);
			req.setAttribute("mvo", vo);
			forward(req, resp, "/WEB-INF/views/boardList.jsp");
		}else {
			resp.sendRedirect("./index.jsp");
		}
	}
	
	private void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
		
	}
}
