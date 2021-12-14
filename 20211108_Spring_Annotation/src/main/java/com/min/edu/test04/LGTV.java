package com.min.edu.test04;

import org.springframework.stereotype.Component;

///xml <bean id="lg" class="com.min.eud.test04.LGTV"/> 이렇게 만들던걸 Component한방으로 연결
@Component(value = "lg")
public class LGTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LG티비 켜짐");
	}

	@Override
	public void powerOff() {
		System.out.println("LG티비 꺼짐");
	}

}
