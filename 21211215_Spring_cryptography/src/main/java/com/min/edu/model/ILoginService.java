package com.min.edu.model;

import com.min.edu.dto.LoginDto;

public interface ILoginService {

	public int join(LoginDto dto);
	public LoginDto login(LoginDto dto);
}
