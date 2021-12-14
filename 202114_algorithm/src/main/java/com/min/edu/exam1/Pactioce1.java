package com.min.edu.exam1;

import java.util.Iterator;

public class Pactioce1 {

	public int solution(int n) {
		int result = n;
		do {
			result = test01(n);
		} while (result/10 != 0);
		
		return result;
	}
	
	public int test01(int n) {
		int answer = 0;
		//입력받은 n을 각 요소별(1자리)로 분리
		//1) 입력받은 숫자를 요소 구분하기 위해서 문자로
		String result = String.valueOf(n);
		
		//2)요소별로 구분한다
		String[] arry= result.split("");
		
		//3)각 요소를 차례대로 더해준다
		for (int i = 0; i < arry.length; i++) {
			answer += Integer.parseInt(arry[i]);
		}
		return answer;
	}
}
