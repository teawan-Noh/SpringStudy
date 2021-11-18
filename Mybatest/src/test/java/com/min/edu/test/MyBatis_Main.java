package com.min.edu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class MyBatis_Main {
	

	public static void main(String[] args) {
		
		SqlSessionFactory manager = new SqlSessionFactoryManager().getFactory();
		SqlSession session =  manager.openSession(true);
		List<JobsVO> lists = session.selectList("com.min.edu.jobs.selectAll");
		System.out.println(lists);
	}

}
