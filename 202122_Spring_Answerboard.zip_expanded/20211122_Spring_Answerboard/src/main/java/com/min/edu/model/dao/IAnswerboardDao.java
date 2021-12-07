package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.AnswerBoard_VO;

public interface IAnswerboardDao {
	
	public int insertBoard(AnswerBoard_VO vo);

	public int updateBoard(AnswerBoard_VO vo);

	public int delflagBoard(Map<String, String[]> seqs);

	public int deleteBoard(Map<String, String[]> seqs);

	public AnswerBoard_VO selectOneBoard(int seq);

	public List<AnswerBoard_VO> selectAllBoard();

	public int replyUp(AnswerBoard_VO vo);

	public int replyIn(AnswerBoard_VO vo);
}
