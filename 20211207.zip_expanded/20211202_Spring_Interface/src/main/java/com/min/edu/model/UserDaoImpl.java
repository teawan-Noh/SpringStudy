package com.min.edu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.UserVo;

@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.edu.model.UserDaoImpl.";

	@Override
	public UserVo login(UserVo vo) {
		return sqlSession.selectOne(NS+"login", vo);
	}

	@Override
	public String regist(UserVo vo) {
		int n = sqlSession.insert(NS+"regist", vo);
		return (n>0)?vo.getId():"";
	}

	@Override
	public String getCheckUser(String checkid) {
		return sqlSession.selectOne(NS+"checkUser", checkid);
	}
	
	

}
