package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerBoard_VO;

@Service
public class AnswerboardServiceImpl implements IAnswerboardService {

	@Autowired
	private IAnswerboardDao dao;
	
	@Override
	public int insertBoard(AnswerBoard_VO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(AnswerBoard_VO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		return dao.delflagBoard(seqs);
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		return dao.deleteBoard(seqs);
	}

	@Override
	public AnswerBoard_VO selectOneBoard(int seq) {
		return dao.selectOneBoard(seq);
	}

	@Override
	public List<AnswerBoard_VO> selectAllBoard() {
		return dao.selectAllBoard();
	}

	@Override
//	@Transactional
	public int reply(AnswerBoard_VO vo) {
		//두가지의 기능을 transaction을 처리하여 사용해야함
		int n = dao.replyUp(vo);
		int m = dao.replyIn(vo);
		return n+m;
	}

}
