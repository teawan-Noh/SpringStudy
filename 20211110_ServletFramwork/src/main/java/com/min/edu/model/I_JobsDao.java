package com.min.edu.model;

import java.util.List;

import com.min.edu.dto.JobsDto;

public interface I_JobsDao {

	//전체 검색
	public List<JobsDto> getAllJobs();
}
