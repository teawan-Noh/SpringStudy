package com.code.up;

public class Print {

	public static void main(String[] args) {
		//print01
		System.out.println("문장");
		System.out.printf("문장");
		System.out.println();
		
		//print02
		System.out.println("문장1 문장2");
		System.out.printf("문장1 문장2");
		System.out.println();
		
		//print03
		System.out.println("Hello \nWorld");
		
		//print04
		System.out.println("\'Hello\'");
		
		//print05
		System.out.println("\"Hello\"");
		
		//print06
		System.out.println("!@#$^&*()");
		
		//print07
		System.out.println("c:\\Download\\hello.cpp");
		
		//print08
		System.out.println("┌┬┐");
		System.out.println("├┼┤");
		System.out.println("└┴┘");
		
		//위의 그림을 유니코드로 출력
		System.out.println("\u250C\u252C\u2510");
		System.out.println("\u251C\u253C\u2524");
		System.out.println("\u2514\u2534\u2518");
	}
}
