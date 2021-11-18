package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsDynamicDaoImpl implements IJobsDynamicDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS = "com.min.edu.model.JobsDynamicDaoImpl.";
	
	@Override
	public List<JobsVO> getJobsIf(Map<String, Object> map) {
		logger.info("getJobsIf IF문을 통한 다이나믹");
		logger.info("조건에 따라 List 혹은 List.JobsVo 한개가 반환됨");
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getJobsIf", map);
	}

	@Override
	public List<JobsVO> getJobsList(List<String> jobs) {
		logger.info("getJobsList java.util.List의 parameter를 foreach처리");
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getJobsList", jobs);
	}

	@Override
	public List<JobsVO> getJobsMap(Map<String, String[]> map) {
		logger.info("getJobsMap java.util.Map<String, String[]> parameter");
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getJobsMap", map);
	}
	
	@Override
	public List<JobsVO> getJobsChoose(JobsVO vo) {
		logger.info("getJobsChoose choose문 사용 : " + vo);
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getJobsChoose", vo);
	}
	
	@Override
	public List<JobsVO> getJobsTrim(JobsVO vo) {
		logger.info("getJobsTrim trim문법을 통해서 prefixOverride 함 : " + vo);
		SqlSession session = manager.openSession();
		
		return session.selectList(NS+"getJobsTrim", vo);
	}
	
	@Override
	public int updateJobsSet(JobsVO vo) {
		logger.info("updateJobsSet Set 태그를 사용하여 업데이트함 : " + vo);
		SqlSession session = manager.openSession(true);
		
		return session.update(NS+"updateJobsSet", vo);
	}
	
	@Override
	public int updateJobsTrim(JobsVO vo) {
		logger.info("updateJobsTrim update를 Trim 태그를 사용함 : " + vo);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateJobsTrim", vo);
	}
	
}
