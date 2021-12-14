package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.BoardVo;

public class BoardDaoImpl implements IBoardDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.BoardDaoImpl.";
	
	@Override
	public int insertBoard(BoardVo vo) {
		logger.info("insertBoard : " + vo);
		SqlSession session = manager.openSession(true);
		
		return session.insert(NS+"insertBoard", vo);
	}

	@Override
	public List<BoardVo> selectAllBoard() {
		logger.info("selectAllBoard");
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"selectAllBoard");
	}

	@Override
	public BoardVo selectOneBoard(String seq) {
		logger.info("selectOneBoard : " + seq);
		SqlSession session = manager.openSession();
		
		return session.selectOne(NS+"selectOneBoard", seq);
	}

	@Override
	public int modifyBoard(Map<String, Object> map) {
		logger.info("modifyBoard : " + map);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"modifyBoard", map);
	}

	@Override
	public int deleteBoard(int seq) {
		logger.info("deleteBoard : " + seq);
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"deleteBoard", seq);
	}

}
