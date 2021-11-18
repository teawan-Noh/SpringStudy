package com.min.edu.test05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//ApplicationContext.xml에  <bean id="myService" class="com.min.edu.test05.UserServiceImpl"/>을 사용한 것과 같다 
//TODO.0002. 현재 클레스는 bean으로 사용하기 위해서 등록 : @Component
//ApplicationContext.xml에 @Component가 등록되기 위해서는 <context:component-scan...>을 선언 해야 한다
@Component
public class UserServiceImpl implements UserService {

	//@Autowired @Resource
//	@Autowired
//	@Qualifier("myUser02")
	@Resource(name = "myUser02")
	private UserDto dto; //선언만 되어있는 형태고 DI를 하지 않았다
	
	public UserServiceImpl(UserDto dto) {
		super();
		this.dto = dto;
	}

	@Override
	public void addUser() {
		System.out.println("추가된 멤버 : " + dto.getUsername());
	}

}
