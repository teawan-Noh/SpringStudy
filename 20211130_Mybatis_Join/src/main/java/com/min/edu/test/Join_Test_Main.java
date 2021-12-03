package com.min.edu.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.mybatis.SqlSessionFactioryManager;


public class Join_Test_Main {

	public static void main(String[] args) {
		
		SqlSessionFactory manager = SqlSessionFactioryManager.getFactory();
		SqlSession session = manager.openSession();
		System.out.println(session);

	}

}
