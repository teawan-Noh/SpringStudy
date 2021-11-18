package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsVO;

public interface IJobsSelectDao {
	public Integer select01(String job_id);
	
	public JobsVO select02(String id);
	
	public List<JobsVO> select03();
	
	public List<JobsVO> select03_1();
	
	public Map<String, JobsVO> select04();
	
	public JobsVO select05(JobsVO vo);
	
	public List<JobsVO> select06(Map<String, Object> map);
	
	@SuppressWarnings("rawtypes")
	public List select07(Object obj);
}
