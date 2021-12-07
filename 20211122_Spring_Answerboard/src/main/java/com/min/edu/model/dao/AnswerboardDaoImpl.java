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
		logger.info("ROOT글 새글 등록");
		return sqlSession.insert(NS+"insertBoard", vo);
	}

	@Override
	public int updateBoard(AnswerBoard_VO vo) {
		logger.info("글 수정");
		return sqlSession.update(NS+"updateBoard", vo);
	}

	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		logger.info("delflag삭제");
		return sqlSession.update(NS+"delflagBoard", seqs);
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		logger.info("delete 삭제");
		return sqlSession.update(NS+"deleteBoard", seqs);
	}

	@Override
	public AnswerBoard_VO selectOneBoard(int seq) {
		logger.info("상세글 조회");
		return sqlSession.selectOne(NS+"selectOneBoard" ,seq);
	}

	@Override
	public List<AnswerBoard_VO> selectAllBoard() {
		logger.info("전체 글 조회");
		return sqlSession.selectList(NS+"selectAllBoard");
	}

	@Override
	public int replyUp(AnswerBoard_VO vo) {
		logger.info("답글 업데이트");
		return sqlSession.update(NS+"replyUp", vo);
	}

	@Override
	public int replyIn(AnswerBoard_VO vo) {
		logger.info("답글 입력");
		return sqlSession.update(NS+"replyIn", vo);
	}

	
}
