package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.min.edu.dto.AnswerBoard_Dto;

public class BoardDaoImpl implements IBoardDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS ="com.min.edu.model.IBoardDao.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public boolean writeBoard(AnswerBoard_Dto dto) {
		int n = sqlSession.insert(NS+"writeBoard", dto);
		return n>0?true:false;
	}

	@Override
	public boolean replyUpdate(AnswerBoard_Dto dto) {
		int n = sqlSession.update(NS+"replyUpdate", dto);
		return n>0?true:false;
	}

	@Override
	public boolean replyInsert(AnswerBoard_Dto dto) {
		int n = sqlSession.insert(NS+"replyInsert", dto);
		return n>0?true:false;
	}

	@Override
	public AnswerBoard_Dto getOneBoard(String seq) {
		return sqlSession.selectOne(NS+"getOneBoard", seq);
	}

	@Override
	public void readCountBoard(String seq) {
		sqlSession.update(NS+"readCountBoard", seq);
		
	}

	@Override
	public boolean delflagBoard(Map<String, String[]> map) {
		int n  = sqlSession.update(NS+"delflagBoard", map);
		return n>0?true:false;
	}

	@Override
	public boolean deleteBoard(List<String> seqs) {
		int n  = sqlSession.delete(NS+"deleteBoard", seqs);
		return n>0?true:false;
	}

	@Override
	public List<AnswerBoard_Dto> deleteBoardSel(String seq) {
		return sqlSession.selectList(NS+"deleteBoardSel", seq);
	}

	@Override
	public List<AnswerBoard_Dto> userBoardList() {
		return sqlSession.selectList(NS+"userBoardList");
	}

	@Override
	public int userBoardListTotal() {
		return sqlSession.selectOne(NS+"userBoardListTotal");
	}

	@Override
	public int adminBoardListTotal() {
		return sqlSession.selectOne(NS+"adminBoardListTotal");
	}

}
