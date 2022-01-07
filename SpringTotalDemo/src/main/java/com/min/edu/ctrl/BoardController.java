package com.min.edu.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.model.IAnswerBoardService;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerBoardService boardService;
	
	@GetMapping(value = "/boardList.do")
	public String boardList(Model model) {
		logger.info("BoardController boardList");
		List<AnswerBoard_Dto> boardList = boardService.userBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "boardList";
	}
	
	
}
