package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsVO;

public interface IJobsSelectService {
	//TODO 01. parameter가 String, result가 Integer 입력
	public Integer select01(String job_id);
	
	//TODO 02. parameter String, result VO 입력
	public JobsVO select02(String id);
	
	//TODO 03. result를 다른 테이블의 결과를 JobsVO에 연결하여 반환
	public List<JobsVO> select03();
	
	//TODO 04. SQL문의 결과를 MyBatis의 resultMap을 연결 반환
	public List<JobsVO> select03_1();
	
	//TODO 05. resultType을 java.util.Map으로 반환하고 selectMap을 사용하여 결과를 출력
	// selectOne() : 한개의 Object, selectList() : 여러개의  Object를 list에 담아서 사용
	public Map<String, JobsVO> select04();
	
	//TODO 06. Parameter를 두개의 값을 전송, 두개의 값을 전달 가능한 JobsVo객체를 사용
	public  JobsVO select05(JobsVO vo);
	
	//TODO 07. Parameter를 두개의 값을 전송, 두개의 값을 전달 가능항 java.util.Map 객체를 사용
	//       	jobid, jobtitle
	public List<JobsVO> select06(Map<String, Object> map);
	
	//TODO 08. Parameter를 java.lang.Object
//				비교연산을 사용하기 위해 CDATA처리를 하여 Mapper.xml를 구성함
	@SuppressWarnings("rawtypes")
	public List select07(Object obj);
}
