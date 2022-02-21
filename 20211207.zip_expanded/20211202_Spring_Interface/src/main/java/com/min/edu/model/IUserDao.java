package com.min.edu.model;

import com.min.edu.vo.UserVo;

public interface IUserDao {

	public UserVo login(UserVo vo);
	
	public String regist(UserVo vo);
	
	public String getCheckUser(String checkid);
}
