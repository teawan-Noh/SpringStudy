package com.min.edu.model;

import java.util.Map;

import com.min.edu.dto.JobsVO;

public interface IJobsBindingDao {

	public JobsVO binding01(Map<String, Object> map);
	
	//Like문은 '#{ID}%' => ''ID'%' 따라서
	//ORACLE문법인 CONCAT을 사용하여 하나의 문자열로 만들면 된다 '#{ID}'||'%' => 'ID'||'%' => 'ID%'
	public JobsVO binding02(Map<String, Object> map);
}
