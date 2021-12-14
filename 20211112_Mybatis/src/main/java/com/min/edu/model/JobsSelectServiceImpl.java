package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;

public class JobsSelectServiceImpl implements IJobsSelectService {

	//로그 처리, IJobsSelectDao를 생성해서 호출
	
	private Logger log = Logger.getLogger(this.getClass());
	private IJobsSelectDao dao;
	
	public JobsSelectServiceImpl() {
		dao = new JobsSelectDaoImpl();
	}


	@Override
	public Integer select01(String job_id) {
		log.info("JobsSelectDaoImpl select01 실행");
		
		return dao.select01(job_id);
	}

	@Override
	public JobsVO select02(String id) {
		log.info("JobsSelectDaoImpl select02 실행");
		
		return dao.select02(id);
	}

	@Override
	public List<JobsVO> select03() {
		log.info("JobsSelectDaoImpl select03 실행");
		return dao.select03();
	}


	@Override
	public List<JobsVO> select03_1() {
		log.info("JobsSelectDaoImpl select03_1 실행");
		return dao.select03_1();
	}


	@Override
	public Map<String, JobsVO> select04() {
		log.info("JobsSelectDaoImpl select04 실행");
		return dao.select04();
	}


	@Override
	public JobsVO select05(JobsVO vo) {
		log.info("JobsSelectDaoImpl select05 실행");
		return dao.select05(vo);
	}


	@Override
	public List<JobsVO> select06(Map<String, Object> map) {
		log.info("JobsSelectDaoImpl select06 실행");
		return dao.select06(map);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List select07(Object obj) {
		log.info("JobsSelectDaoImpl select07 실행");
		return dao.select07(obj);
	}

}
