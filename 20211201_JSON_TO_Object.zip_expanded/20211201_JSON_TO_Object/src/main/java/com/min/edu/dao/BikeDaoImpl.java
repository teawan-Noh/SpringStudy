package com.min.edu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dto.BikeDto;
import com.min.edu.mybatis.SqlSessionFactoryManager;

public class BikeDaoImpl implements IBikeDao{

	private SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
	private final String NS= "bike.access.";
	
	@Override
	public int bikeInsert(List<BikeDto> dtos) {
		int n = 0;
		// mybaits openSession은 기본이 manual commit 
		// 생성할때 true값을 입력하면 Autocommit / false혹은 default인경우는 manual로 동작
		// default 생성 -> for -> manual commit
		SqlSession session = manager.openSession(); // manual commit
		for (BikeDto dto : dtos) {
			n += session.insert(NS+"bikeInsert",dto);
		}
		session.commit();
		session.close();
		return n;
	}

	@Override
	public int bikeDelete() {
		SqlSession session = manager.openSession(true); // autoCommit
		return session.delete(NS+"bikeDelete");
	}

}
