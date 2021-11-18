package com.min.edu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dto.JobsDto;
import com.min.edu.model.I_JobsDao;
import com.min.edu.model.JobsDaoImpl;

public class ListHandler implements Handler {

	@Override
	public String handle(HttpServletRequest req, HttpServletResponse resp) {
		
//		List<String> season = new ArrayList<String>();
//		season.add("봄");
//		season.add("여름");
//		season.add("가을");
//		season.add("겨울");
//		req.setAttribute("season", season);
		I_JobsDao dao = new JobsDaoImpl();
		
		List<JobsDto> lists = null;
		lists = dao.getAllJobs();
		req.setAttribute("lists", lists);
		
		return "list";
	}

}
