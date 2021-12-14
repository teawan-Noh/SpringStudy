package com.min.edu.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.AnswerBoard_VO;

@Repository
public class AnswerboardDaoImpl implements IAnswerboardDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.model.dao.AnswerboardDaoImpl.";
	
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
		logger.info("단일 글 조회");
		return sqlSession.selectOne(NS+"selectOneBoard", seq);
	}

	@Override
	public List<AnswerBoard_VO> selectAllBoard() {
		logger.info("전체 글 조회");
		return sqlSession.selectList(NS+"selectAllBoard");
	}

}
