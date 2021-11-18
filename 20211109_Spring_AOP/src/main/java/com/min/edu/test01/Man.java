package com.min.edu.test01;

public class Man {
	void classWork() {
		System.out.println("출력을 체크한다"); //CCC before
		
		try {
			System.out.println("뉴를 본다"); // CC  
		} catch (Exception e) {
			System.out.println("쉬는날 이다"); //  after-throwing
		}finally {
			System.out.println("강의장을 나간다"); // after
		}
		
	}
}
