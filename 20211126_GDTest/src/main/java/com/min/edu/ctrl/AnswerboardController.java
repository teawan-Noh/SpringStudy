package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.service.IAnswerboardService;
import com.min.edu.vo.AnswerboardVO;

@Controller
public class AnswerboardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerboardService answerboardService;
	
	@GetMapping("/boardList.do")
	public String boardList(Model model) {
		logger.info("AnswerboardController boardList");
		
		List<AnswerboardVO> list = answerboardService.selectAllBoard();
		model.addAttribute("list", list);
		
		return "boardList";
		
	}
	
	@GetMapping("/boardDetail.do")
	public String boardDetail(int seq, Model model) {
		logger.info("AnswerboardController boardDetail");
		AnswerboardVO vo = answerboardService.selectOneBoard(seq);
		model.addAttribute("boardOne", vo);
		
		return "boardDetail";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(@RequestParam String content, int seq) {
		logger.info("AnswerboardController boardUpdate");
		
		AnswerboardVO vo = new AnswerboardVO();
		vo.setSeq(seq);
		vo.setContent(content);
		answerboardService.updateBoard(vo);
		
		return "redirect:/boardList.do";
		
	}
	
	@GetMapping("/boardDelflag.do")
	public String boardDelflag(String[] seq) {
		logger.info("AnswerboardController boardDelflag");
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		
		answerboardService.delflagBoard(map);
		
		return "redirect:/boardList.do";
		
	}
	
	@GetMapping("/insertBoardForm.do")
	public String insertBoardForm() {
		
		return "insertBoardForm";
	}
	
	@PostMapping("/insertBoard.do")
	public String insertBoard(AnswerboardVO vo) {
		logger.info("AnswerboardController insertBoard");
		
		int cnt = answerboardService.insertBoard(vo);
		if(cnt == 1) {
			return "redirect:/boardList.do";
			
		} else {
			return "index.jsp";
		}
		
	}
	
}
