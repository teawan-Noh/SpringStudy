package com.min.edu.test01;
//TODO 002. 인터페이스의 기능을 가진 DTO -> Bean
public class MessageBeanImpl implements MessageBean {

	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		this.fruit = "strawberry";
		this.cost = 14000;
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		super();
		this.fruit = fruit;
		this.cost = cost;
	}

	@Override
	public void sayHello() {
		System.out.println(fruit +"의 가격은: " + cost);

	}

}
