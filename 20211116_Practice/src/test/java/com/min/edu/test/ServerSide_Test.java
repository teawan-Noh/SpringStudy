package com.min.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.model.BoardDaoImpl;
import com.min.edu.model.IBoardDao;
import com.min.edu.mybatis.SqlSessionFactoryManager;
import com.min.edu.vo.BoardVo;

public class ServerSide_Test {
	public static void main(String[] args) {
		//1. SqlSessionFactory TEST
//		SqlSessionFactory manager = SqlSessionFactoryManager.getFactory();
//		manager.openSession();
		
		//2. dao test
		IBoardDao dao = new BoardDaoImpl();
		System.out.println(dao.selectAllBoard());
//		System.out.println(dao.selectOneBoard("1"));
//		System.out.println(dao.insertBoard(new BoardVo("test제목", "tset")));
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("seqmap", 1);
//		map.put("contentmap", "변경된 content");
//		System.out.println(dao.modifyBoard(map));
		
//		System.out.println(dao.deleteBoard(4));
	}
}
