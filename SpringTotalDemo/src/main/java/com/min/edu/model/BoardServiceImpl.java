package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.min.edu.dto.AnswerBoard_Dto;

public class BoardServiceImpl implements IBoardService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBoardDao dao;
	
	@Override
	public boolean writeBoard(AnswerBoard_Dto dto) {
		logger.info("BoardServiceImpl 새글작성 {}", dto);
		return dao.writeBoard(dto);
	}

	@Override
	public boolean reply(AnswerBoard_Dto dto) {
		logger.info("BoardServiceImpl 답글작성 {}", dto);
		boolean u = dao.replyUpdate(dto);
		boolean i = dao.replyInsert(dto); 
		return (u|i)?true:false;
	}

	@Override
	public AnswerBoard_Dto getOneBoard(String seq) {
		logger.info("BoardServiceImpl 상세조회 {}", seq);
		return dao.getOneBoard(seq);
	}

	@Override
	public void readCountBoard(String seq) {
		logger.info("BoardServiceImpl 조회수 증가 {}", seq);
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		logger.info("BoardServiceImpl 삭제(delflag) {}", map);
		return dao.delflagBoard(map);
	}

	@Override
	public boolean deleteBoard(List<String> seqs) {
		logger.info("BoardServiceImpl DB삭제 {}", seqs);
		return dao.deleteBoard(seqs);
	}

	@Override
	public List<AnswerBoard_Dto> deleteBoardSel(String seq) {
		logger.info("BoardServiceImpl 삭제대상 조회 {}", seq);
		return dao.deleteBoardSel(seq);
	}

	@Override
	public List<AnswerBoard_Dto> userBoardList() {
		logger.info("BoardServiceImpl 사용자 전체 글 보기");
		return dao.userBoardList();
	}

	@Override
	public int userBoardListTotal() {
		logger.info("BoardServiceImpl 사용자 전체글 개수");
		return dao.userBoardListTotal();
	}

	@Override
	public int adminBoardListTotal() {
		logger.info("BoardServiceImpl 관리자 전체 글 보기");
		return dao.adminBoardListTotal();
	}

}
