package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerboardVO;

@Service
public class AnswerboardServiceImpl implements IAnswerboardService {

	@Autowired
	private IAnswerboardDao dao;
	
	@Override
	public int insertBoard(AnswerboardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(AnswerboardVO vo) {
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
	public AnswerboardVO selectOneBoard(int seq) {
		return dao.selectOneBoard(seq);
	}

	@Override
	public List<AnswerboardVO> selectAllBoard() {
		return dao.selectAllBoard();
	}

	@Override
	public int reply(AnswerboardVO vo) {
		int u = dao.replyUp(vo);
		int i = dao.replyIn(vo);
		return u+i;
	}

}
