package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {

	private static SqlSessionFactory factory;
	
	static {
		String path = "com/min/edu/mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(path);  //xml을 읽어서 자바(Mybatis에서 필요로하는)의 key값 형태로 읽음
			factory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("SqlSessionFactory 객체 생성 성공");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	
}
