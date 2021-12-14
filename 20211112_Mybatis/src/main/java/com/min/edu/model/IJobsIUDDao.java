package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.JobsVO;

//insert, delete, update 는  성공한 row의 개수가 반환타입
public interface IJobsIUDDao {

	//TODO 09. insert문의 실행과 selectkey를 통한 입력 값 확인
	public int insert01(JobsVO vo);
	
	//TODO 10. update문의 입력 parameter를 java.util.Map으로 한다
	public int update01(Map<String, Object> map);
	
	//TODO 11. delete문
	public int delete01(int seq);
}
