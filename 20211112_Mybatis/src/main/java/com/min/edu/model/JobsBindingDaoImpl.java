package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.JobsVO;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class JobsBindingDaoImpl implements IJobsBindingDao {

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private Logger log =  Logger.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.JobsBindingDaoImpl.";
	
	@Override
	public JobsVO binding01(Map<String, Object> map) {
		log.info("JobsBindingDaoImpl binding01 : " + map);
		SqlSession session = manager.openSession();
		List<JobsVO> lists = session.selectList(NS+"binding01", map);
		System.out.println(lists);
		return (lists.size()==0)? new JobsVO():lists.get(0);
	}

	@Override
	public JobsVO binding02(Map<String, Object> map) {
		log.info("JobsBindingDaoImpl binding02 : " + map);
		SqlSession session = manager.openSession();
		List<JobsVO> lists = session.selectList(NS+"binding02", map);
		System.out.println(lists);
		return (lists.size()==0)? new JobsVO():lists.get(0);
	}
	
}




