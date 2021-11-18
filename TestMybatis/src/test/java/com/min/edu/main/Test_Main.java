package com.min.edu.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class Test_Main {
	public static void main(String[] args) {
		
		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
		SqlSession session = manager.openSession(true);
		List<JobsVO> list = session.selectList("com.min.edu.jobs.selectAll");
		System.out.println(list);
	}
}
