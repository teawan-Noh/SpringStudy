package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RowNum_Dto;

public interface IAnswerBoardDao {

//	writeBoard            새글쓰기
	public boolean writeBoard(AnswerBoard_Dto dto);
	
//	replyUpdate           답글 업데이트
	public boolean replyUpdate(AnswerBoard_Dto dto);
//	replyInsert           답글 입력
	public boolean replyInsert(AnswerBoard_Dto dto);
	
//	getOneBoard           상세글 보기
	public AnswerBoard_Dto getOneBoard(String seq);
	
//	readCountBoard        조회수 증가
	public void readCountBoard(String seq);
	
//	delflagBoard          글삭제 Delflag
	public boolean delflagBoard(Map<String, String[]> map);
	
//	deleteBoard           글삭제 DB
	public boolean deleteBoard(List<String> seqs);
	
//	deleteBoardSel        하위 삭제 대상 조회
	public List<AnswerBoard_Dto> deleteBoardSel(String seq);
	
//	userBoardList         사용자 게시글 전체
	public List<AnswerBoard_Dto> userBoardList();
	
	
//	userBoardListRow      사용자 게글 전체조회(페이징)
	public List<AnswerBoard_Dto> userBoardListRow(RowNum_Dto dto);
//	userBoardListTotal    사용자 전체 글 갯수
	public int userBoardListTotal();
	
//	adminBoardListRow     관리자 게시글 전체조회(페이징)
	public List<AnswerBoard_Dto> adminBoardListRow(RowNum_Dto dto);
//	adminBoardListTotal   관리자 전체 글 갯수
	public int adminBoardListTotal();
	
	public boolean modifyBoard(AnswerBoard_Dto dto);
	
}
