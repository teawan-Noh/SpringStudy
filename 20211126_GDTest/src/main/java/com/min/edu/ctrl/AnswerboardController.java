package com.min.edu.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "boardList";
		
	}
	
	@GetMapping("/boardDetail.do")
	public String boardDetail(int seq, Model model) {
		
		AnswerboardVO vo = answerboardService.selectOneBoard(seq);
		model.addAttribute("boardOne", vo);
		System.out.println("확인22222222222222222222222222222222222222222222222" + vo);
		
		return "boardDetail";
	}
	
}
