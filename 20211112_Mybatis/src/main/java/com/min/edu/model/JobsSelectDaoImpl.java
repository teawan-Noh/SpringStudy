package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsSelectDaoImpl implements IJobsSelectDao {

	// Mybatis 사용을 위한 객체 SqlSessionFactory를 가져오고(SqlSessionFactoryManager)
	// log 처리
	
	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger loger =  Logger.getLogger(this.getClass());
	
	//nameSpace
	private final String ns = "com.min.edu.model.select.";
	
	@Override
	public Integer select01(String job_id) {
		//SqlSessionFactory객체를 사용하기 위해 SqlSession 객체를 사용해야한다.
		SqlSession session =  manager.openSession();
		Integer cnt = session.selectOne(ns + "select01", job_id);
		
		return cnt;
	}

	@Override
	public JobsVO select02(String id) {
		loger.info("JobsSelectDaoImpl select02: " + id);
		JobsVO vo = null;
		SqlSession session = manager.openSession();
		vo = session.selectOne(ns + "select02", id);
		return vo;
	}

	@Override
	public List<JobsVO> select03() {
		loger.info("JobsSelectDaoImpl select03");
		List<JobsVO> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(ns + "select03");
		return lists;
	}

	@Override
	public List<JobsVO> select03_1() {
		loger.info("JobsSelectDaoImpl select03_1");
		List<JobsVO> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(ns + "select03_1");
		return lists;
	}

	@Override
	public Map<String, JobsVO> select04() {
		loger.info("JobsSelectDaoImpl select04");
		Map<String, JobsVO> jobsMap = null;
		SqlSession session = manager.openSession();
		jobsMap = session.selectMap(ns + "select04", "JOB_ID");
		
		return jobsMap;
	}

	@Override
	public JobsVO select05(JobsVO vo) {
		loger.info("JobsSelectDaoImpl select05");
		JobsVO dto = null;
		SqlSession session = manager.openSession();
		dto = session.selectOne(ns+"select05", vo);
		
		return dto;
		
	}

	@Override
	public List<JobsVO> select06(Map<String, Object> map) {
		loger.info("JobsSelectDaoImpl select06");
		SqlSession session = manager.openSession();
		List<JobsVO> lists = session.selectList(ns+"select06", map);
		
		return lists;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List select07(Object obj) {
		loger.info("JobsSelectDaoImpl select07");
		SqlSession session = manager.openSession();
		List l = session.selectList(ns+"select07", obj);
		return l;
	}

}
