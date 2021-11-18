package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.JobsVO;

public interface IJobsDynamicDao {

	public List<JobsVO> getJobsIf(Map<String, Object> map);
	
	//parameter가 java.util.List인 경우 In절을 List의 갯수만큼 생성
	public List<JobsVO> getJobsList(List<String> jobs);
	
	//parameter가 java.util.Map<String, String[]>의 경우 key를 collection으로 사용하여 
	//값인 String[]의 갯수만큼 생성 
	public List<JobsVO> getJobsMap(Map<String, String[]> map);
	
	//choose문법을 통해서 한개의 조건일 때 동작함
	public List<JobsVO> getJobsChoose(JobsVO vo);
	
	//Trim 문법을 사용하여 두번쨰의 if의 결과는 and/or을 where로 override 하여 생성
	public List<JobsVO> getJobsTrim(JobsVO vo);
	
	/**
	 * MyBatis Dynamic Query Set 사용<br>
	 * @author 나
	 * @since 2021-11-18
	 * @param JobsVO
	 * @return 성공한 ROW의 개수
	 */
	public int updateJobsSet(JobsVO vo);
	
	/**
	 * MyBatis Dynamic Query update문을 trim의 suffix Override 사용<br>
	 * @author 나
	 * @since 2021-11-18
	 * @param JobsVO
	 * @return 성공한 ROW의 개수
	 */
	public int updateJobsTrim(JobsVO vo);
	
}
