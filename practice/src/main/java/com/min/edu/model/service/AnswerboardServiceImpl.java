package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.dao.IAnswerboardDao;
import com.min.edu.vo.AnswerBoard_VO;

@Service
public class AnswerboardServiceImpl implements IAnswerboardService {

	@Autowired
	private IAnswerboardDao dao;
	
	@Override
	public int insertBoard(AnswerBoard_VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(AnswerBoard_VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnswerBoard_VO selectOneBoard(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnswerBoard_VO> selectAllBoard() {
		return dao.selectAllBoard();
	}

}
