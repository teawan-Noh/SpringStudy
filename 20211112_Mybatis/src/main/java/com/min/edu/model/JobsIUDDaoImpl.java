package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsIUDDaoImpl implements IJobsIUDDao{

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.JobsIDUImpl.";
	
	@Override
	public int insert01(JobsVO vo) {
		logger.info("JobsIUDDaoImpl insert01 : " + vo);
		SqlSession session = manager.openSession(true); // default값이 false : manual commit 상태 //true 넣어주면 auto commit상태
		
		return session.insert(NS + "insert01", vo);
	}

	@Override
	public int update01(Map<String, Object> map) {
		logger.info("JobsIUDDaoImpl update01 : " + map);
		SqlSession session = manager.openSession(true); //JDBC의 수정이 DB에 반영(Commit)되기 위해서는 반드시 true를 입력
		
		return session.update(NS + "update01", map);
	}

	@Override
	public int delete01(int seq) {
		logger.info("JobsIUDDaoImpl delete01 : " + seq);
		SqlSession session = manager.openSession(true);
		
		return session.delete(NS + "delete01", seq);
	}
}
