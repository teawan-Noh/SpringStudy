package com.min.edu.main;

import java.util.List;

import com.min.edu.dto.JobsDto;
import com.min.edu.model.I_JobsDao;
import com.min.edu.model.JobsDaoImpl;

public class JDBC_Test_Main {

	public static void main(String[] args) {

		I_JobsDao dao = new JobsDaoImpl();
		dao.getAllJobs();
		
		List<JobsDto> lists = dao.getAllJobs();
		System.out.println(lists);
	}

}
