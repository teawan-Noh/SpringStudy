package com.min.edu.test05;

import org.springframework.beans.factory.annotation.Required;

public class UserDto {

		private String username;

		public UserDto() {
		}
		
		public UserDto(String username) {
			super();
			this.username = username;
		}

		public String getUsername() {
			return username;
		}
		//Required를 사용하면 xml bean에서 꼭 설정 해줘야 한다. ex)<property name="username" value="희동이"/>
		@Required
		public void setUsername(String username) {
			this.username = username;
		}
		
		
}
