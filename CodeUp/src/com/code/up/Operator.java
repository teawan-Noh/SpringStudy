package com.code.up;

import java.io.IOException;
import java.util.Scanner;

public class Operator {

	static int sum(int a, int b) {
		return a+b;
	}
	
	/**
	 * @param args
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// 정수 2개 입력받아 합 출력하기1
//		int result = sum(sc.nextInt(), sc.nextInt());
//		System.out.println(result);
		
		//공백 구분 버전
//		String num = sc.nextLine();
//		String [] split = num.split(" ");
//		System.out.println(sum(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
		
		//정수 1개 입력받아 부호 바꿔 출력하기
//		int a = sc.nextInt();
//		if(a > 0) {
//			a = -a;
//		}else if(a<0) {
//			a = -(a);
//		}
//		System.out.printf("%d", a);
		
		int a = 3;
		int b = 5;
		
		System.out.println(b%a);
	}

}
