package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RowNum_Dto;

@Service
public class AnswerBoardServiceImple implements IAnswerBoardService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IAnswerBoardDao dao;
	
	@Override
	public boolean writeBoard(AnswerBoard_Dto dto) {
		logger.info("AnswerBoardServiceImpl 새글작성 {}", dto);
		return dao.writeBoard(dto);
	}

	@Override
	public boolean reply(AnswerBoard_Dto dto) {
		logger.info("AnswerBoardServiceImpl 답글달기 update/insert {}",dto);
		boolean i = dao.replyUpdate(dto);
		boolean u = dao.replyInsert(dto);
		return (i|u)?true:false;
	}

	@Override
	public AnswerBoard_Dto getOneBoard(String seq) {
		logger.info("AnswerBoardServiceImpl 상세조회 {}",seq);
		return dao.getOneBoard(seq);
	}

	@Override
	public void readCountBoard(String seq) {
		logger.info("AnswerBoardServiceImpl 조회수증가", seq);
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		logger.info("AnswerBoardServiceImpl 삭제 표기 {}", map);
		return dao.delflagBoard(map);
	}

	@Override
	public boolean deleteBoard(List<String> seqs) {
		logger.info("AnswerBoardServiceImpl DB삭제 {}" , seqs);
		return dao.deleteBoard(seqs);
	}

	@Override
	public List<AnswerBoard_Dto> deleteBoardSel(String seq) {
		logger.info("AnswerBoardServiceImpl 삭제 대상 조회 {}", seq);
		return dao.deleteBoardSel(seq);
	}

	@Override
	public List<AnswerBoard_Dto> userBoardList() {
		logger.info("AnswerBoardServiceImpl 사용자 전체 글 보기");
		return dao.userBoardList();
	}

	@Override
	public List<AnswerBoard_Dto> userBoardListRow(RowNum_Dto dto) {
		logger.info("AnswerBoardServiceImpl 사용자 페이징 전체 글 보기 {}",dto);
		return dao.userBoardListRow(dto);
	}

	@Override
	public int userBoardListTotal() {
		logger.info("AnswerBoardServiceImpl 사용자 전체 글 갯수");
		return dao.userBoardListTotal();
	}

	@Override
	public List<AnswerBoard_Dto> adminBoardListRow(RowNum_Dto dto) {
		logger.info("AnswerBoardServiceImpl 관리자 페이징 전체 글 보기 {}",dto);
		return dao.adminBoardListRow(dto);
	}

	@Override
	public int adminBoardListTotal() {
		logger.info("AnswerBoardServiceImpl 관리자 전체 글 갯수");
		return dao.adminBoardListTotal();
	}

	@Override
	public boolean modifyBoard(AnswerBoard_Dto dto) {
		logger.info("AnswerBoardServiceImpl 게시글 수정");
		return dao.modifyBoard(dto);
	}

}





