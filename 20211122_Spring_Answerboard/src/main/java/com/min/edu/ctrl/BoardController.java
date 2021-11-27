package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.model.service.IAnswerboardService;
import com.min.edu.vo.AnswerBoard_VO;

/**
 * 답변형 게시판의 요청을 처리하는 클래스
 * @author taewanNoh
 * @since 2021. 11. 23
 */
@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IAnswerboardService answerboardServiceImpl;

	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, HttpSession session) {
		session.setAttribute("userid", "USER25");
		session.setAttribute("auth", "U");

		session.setMaxInactiveInterval(120);
		// session을 삭제하는 방법 두가지
		// 1) session객체 자체를 삭제 , null로 객체를 만듦 invalidate
		// 2) session 객체의 하나의 값 삭제 remove("name")

		logger.info("BoardController 전체글 조회 boardList");
		List<AnswerBoard_VO> lists = answerboardServiceImpl.selectAllBoard();
		model.addAttribute("lists", lists);

		return "boardList";
	}

	// Parameter 받는 방법
	@PostMapping("/multiDel.do")
	public String multiDel(
//			String chk
			String[] chk
//			Map<String, String> chk//맵은 못받음 0 나옴
//			HttpServletRequest req
//			int[] chk
	) {
		logger.info("BoardController 다중삭제 multiDel");
//		System.out.println("tag의 name으로 바인딩: " + chk);
		System.out.println("tag의 name 배열로 바인딩: " + Arrays.toString(chk));
//		System.out.println("tag의 name Map 바인딩: " + chk.size());
//		System.out.println("HttpServletRequest 객체를 사용: " + Arrays.toString(req.getParameterValues("chk")));
//		System.out.println("tag의 name 배열로 바인딩(int)" + chk.getClass()); // [I : integer 배열이다

		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", chk);
		int cnt = answerboardServiceImpl.delflagBoard(map);
		logger.info("delflag된 개수는? ", cnt);

		return "redirect:/boardList.do";
	}

	// insertBoard.do
	@GetMapping("/insertBoardForm.do")
	public String insertBoardForm() {
		logger.info("BoardController 새글 입력폼 insertBoardForm");

		return "insertBoard";
	}

	@PostMapping("/insertBoard.do")
	public String insertBoard(AnswerBoard_VO vo, HttpServletResponse resp) throws IOException {
		logger.info("BoardController 새글 입력 insertBoard : {}", vo);
		int cnt = answerboardServiceImpl.insertBoard(vo);
		if (cnt == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('성공적으로 새글이 입력되었습니다'); location.href='./boardList.do';</script>");
			out.flush();

			return null;
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<scrip>alert('새글 입력 실패'); location.href='index.jsp';</scrip>");
			out.flush();

			return null;
		}
	}

	@RequestMapping(value = "/detailBoard.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView detailBoard(int seq) {
		logger.info("BoardController 새글 입력 detailBoard : {}", seq);
		ModelAndView mav = new ModelAndView();
		// 값과 이동 jsp를 같이 mav 객체에 담아준다

		AnswerBoard_VO vo = answerboardServiceImpl.selectOneBoard(seq);
		mav.setViewName("detailBoard");
		mav.addObject("avo", vo);

		return mav;
	}

	@PostMapping("/replyBoardForm.do")
	public String replyBoardForm(String seq) {
		System.out.println(seq);

		return seq;
	}
	@PostMapping("/replyBoard.do")
	public String replyBoard(AnswerBoard_VO vo, HttpSession session) {
		String writer = (String)session.getAttribute("userid");
		logger.info("BoardController 답글입력 replyBoard : {}", vo);
		logger.info("BoardController 답글입력 replyBoard : {}", writer);
		vo.setId(writer);
		int cnt = answerboardServiceImpl.reply(vo);
		if(cnt>0) {
			return "redirect:/boardList.do";
		}
		return "index.jsp";
	}
}
