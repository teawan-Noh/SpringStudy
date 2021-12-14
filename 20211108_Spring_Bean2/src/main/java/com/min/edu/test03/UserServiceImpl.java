package com.min.edu.test03;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser(UserDto dto) {
		System.out.println("addUser 호출");
	}

	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}
