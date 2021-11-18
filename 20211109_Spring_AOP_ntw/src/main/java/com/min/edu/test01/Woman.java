package com.min.edu.test01;

public class Woman {
	
	void classWork() {
		System.out.println("출석을 체크한다"); // CCC befor
		
		try {
			System.out.println("공부를 한다"); // CC
		} catch (Exception e) {
			System.out.println("쉬는날이다");  // after-throwing
		} finally {
			System.out.println("강의장을 나간다"); // after
		}
	}
}
