package com.min.edu.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dto.LoginDto;

@Service
public class LoginServiceImpl implements ILoginService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ILoginDao dao;
	
	@Override
	public int join(LoginDto dto) {
		logger.info("LoginServiceImpl 회원가입 {}", dto);
		return dao.join(dto);
	}

	@Override
	public LoginDto login(LoginDto dto) {
		logger.info("LoginServiceImpl 로그인 {}", dto);
		return dao.login(dto);
	}

}
