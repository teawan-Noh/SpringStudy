package com.min.edu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.dto.LoginDto;

@Repository
public class LoginDaoImpl implements ILoginDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//Spring Security의 문자 암호화 PasswordEncoding
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int join(LoginDto dto) {
		String encPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encPassword);
		logger.info("회원가입 암호화 처리된 DTO : {}", dto);
		
		return sqlSession.insert("com.min.edu.model.LoginDaoImpl.join", dto);
	}

	@Override
	public LoginDto login(LoginDto dto) {
		String pw = sqlSession.selectOne("com.min.edu.model.LoginDaoImpl.selPassword",dto); //암호화 되어있는 password
		String rawPw = dto.getPassword(); // 입력받은 password
		
		logger.info("디비입력 Password {}", pw);
		logger.info("입력받은 Password {}", rawPw);
		
		if(passwordEncoder.matches(rawPw, pw)) {
			logger.info("비밀번호 일치");
			return sqlSession.selectOne("com.min.edu.model.LoginDaoImpl.login", dto);
		}
		
		return null;
	}

}
