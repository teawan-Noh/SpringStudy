package com.min.edu.model.service;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AnswerBoard_VO;

public interface IAnswerboardService {

	public int insertBoard(AnswerBoard_VO vo);

	public int updateBoard(AnswerBoard_VO vo);

	public int delflagBoard(Map<String, String[]> seqs);

	public int deleteBoard(Map<String, String[]> seqs);

	public AnswerBoard_VO selectOneBoard(int seq);

	public List<AnswerBoard_VO> selectAllBoard();

	public int reply(AnswerBoard_VO vo);

}
