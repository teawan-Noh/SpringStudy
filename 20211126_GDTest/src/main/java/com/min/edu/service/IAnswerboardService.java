package com.min.edu.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AnswerboardVO;

public interface IAnswerboardService {

public int insertBoard(AnswerboardVO vo);
	
	public int updateBoard(AnswerboardVO vo);
	
	public int delflagBoard(Map<String, String[]> seqs);
	
	public int deleteBoard(Map<String, String[]> seqs);
	
	public AnswerboardVO selectOneBoard(int seq);
	
	public List<AnswerboardVO> selectAllBoard();
	
	public int reply(AnswerboardVO vo);
	
}
