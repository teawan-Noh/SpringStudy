package com.min.edu.dao;

import java.util.List;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.AnswerboardVO;

@Repository
public class AnswerboardDaoImpl implements IAnswerboardDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS = "com.min.edu.dao.AnswerboardDaoImpl.";
	
	
	@Override
	public int insertBoard(AnswerboardVO vo) {
		logger.info("글쓰기");
		return sqlSession.insert(NS+"insertBoard", vo);
	}

	@Override
	public int updateBoard(AnswerboardVO vo) {
		logger.info("글수정");
		return sqlSession.update(NS+"updateBoard", vo);
	}

	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		logger.info("글삭제(update-delflag)");
		return sqlSession.update(NS+"deflagBoard", seqs);
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		logger.info("글삭제(delete-delete)");
		return sqlSession.delete(NS+"deleteBoard", seqs);
	}

	@Override
	public AnswerboardVO selectOneBoard(int seq) {
		logger.info("전체 단일 글 조회");
		return sqlSession.selectOne(NS+"selectOneBoard", seq);
	}

	@Override
	public List<AnswerboardVO> selectAllBoard() {
		logger.info("전체 글 조회");
		return sqlSession.selectList(NS+"selectAllBoard");
	}

	@Override
	public int replyUp(AnswerboardVO vo) {
		logger.info("답글 작성 STEP update");
		return sqlSession.update(NS+"replyUp", vo);
	}

	@Override
	public int replyIn(AnswerboardVO vo) {
		logger.info("답글 작성 insert");
		return sqlSession.insert(NS+"replyIn", vo);
	}

}
