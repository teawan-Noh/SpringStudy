package com.min.edu.model;

import com.min.edu.dto.LoginDto;

public interface ILoginDao {

	public int join(LoginDto dto);
	public LoginDto login(LoginDto dto);
}
