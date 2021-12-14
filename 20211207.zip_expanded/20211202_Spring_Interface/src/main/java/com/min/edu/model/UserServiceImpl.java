package com.min.edu.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserVo login(UserVo vo) {
		logger.info("UserServiceImpl 로그인");
		return dao.login(vo);
	}

	@Override
	public String regist(UserVo vo) {
		logger.info("UserServiceImpl 회원가입");
		return dao.regist(vo);
	}

	@Override
	public String getCheckUser(String checkid) {
		logger.info("UserServiceImpl 아이디 중복 확인");
		return dao.getCheckUser(checkid);
	}

}
