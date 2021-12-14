package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BoardVo;

public interface IBoardDao {
	
	//입력 insertBoard
	public int insertBoard(BoardVo vo);
	//전체조회 selectAllBoard
	public List<BoardVo> selectAllBoard();
	//단일조회 selectOneBoard
	public BoardVo selectOneBoard(String seq);
	//수정 modifyBoard
	public int modifyBoard(Map<String, Object> map);
	//삭제 deleteBoard
	public int deleteBoard(int seq);
}
