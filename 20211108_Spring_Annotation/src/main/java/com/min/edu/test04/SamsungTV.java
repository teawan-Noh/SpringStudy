package com.min.edu.test04;

import org.springframework.stereotype.Component;

//xml <bean id="samsung" class="com.min.eud.test04.SanmsungTV"/> 이렇게 만들던걸 Component한방으로 연결
@Component(value = "samsung")
public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성티비 켜짐");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성티비 꺼짐");
	}

}
