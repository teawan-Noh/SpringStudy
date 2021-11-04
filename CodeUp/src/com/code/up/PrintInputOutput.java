package com.code.up;

import java.util.Scanner;

public class PrintInputOutput {

	
	public static void main(String[] args) {
		int n = 15;
		int n2 = 152;
		char c = 'a';
		double d = 1.1123;
		float f = 2.22f;
		long l = 2221312313L;
		
		Scanner s = new Scanner(System.in);
		
		//정수 입력받아 출력 %d
		System.out.println(n);
		System.out.printf("%d\n",n);
		System.out.printf("%d \n", l);
		System.out.printf("문자출력에 d안에다 n값을 넣어서 출력하겠다는 뜻 %d \n",n);
		
		//문자 입력받아 출력 %c
		System.out.println(c);
		System.out.printf("%c \n", c);
		
		//실수 입력받아 출력 %f
		System.out.println(f);
		System.out.printf("%f \n", f);
		System.out.printf("%f \n", d);
		
		//정수 2개를 입력받아 출력
		System.out.println(n + " " + n2);
		System.out.printf("%d%d",n,n2);
		System.out.println();
		//2개의 문자(ASCII CODE)를 입력받아서 순서를 바꿔 출력해보자.
		String a = "ASCII";
		String b = "CODE";
		
		System.out.println(b + " " + a);
		System.out.printf("%s %s",b,a);
		System.out.println();
		
		//실수(float) 1개를 입력받아 저장한 후,
		//저장되어 있는 값을 소수점 셋 째 자리에서 반올림하여
		//소수점 이하 둘 째 자리까지 출력하시오.
//		float f1 = s.nextFloat();
//		System.out.printf("%.2f",f1);
//		System.out.println();
		
		//int형 정수 1개를 입력받아 공백을 사이에 두고 3번 출력해보자.
//		System.out.printf("%d %d %d",s.nextInt(),s.nextInt(),s.nextInt());
//		System.out.println();
		
		//시간 입력받아 그대로 출력하기
//		System.out.printf("%s",s.next());
		
		//연월일 출력 (code up 1019 문제)
//		System.out.printf("%d.%02d.%02d",s.nextInt(), s.nextInt(), s.nextInt());
		
		//주민번호 입력받아 형태 바꾸어 출력
//		String p1 = s.next();
//		p1 = p1.replace("-", "");
//		System.out.printf(p1);
		
		//공백이 포함된 문장 입력받아 출력 
//		System.out.printf("%s", s.nextLine());
		
		//실수 1개 입력받아 부분별로 출력하기
//		String b2 = s.next();
//		int b22 = b2.indexOf(".");
//		System.out.println(b2.substring(0,b22)+"\n"+b2.substring(b22+1,b2.length()));
		
		//단어 1개 입력받아 나누어 출력하기 
//		String s1 = s.nextLine();
//		for (int i = 0; i < s1.length(); i++) {
//			System.out.printf("\'%c\'\n",s1.charAt(i));
//		}
		
		//정수 1개입력받아 나누어 출력하기
//		String s1 = s.nextLine();
//		char [] arr = s1.toCharArray();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print("["+arr[i]);
//			for (int j = arr.length-1; j > i; j--) {
//				System.out.print("0");
//			}
//			System.out.println("]");
//		}
		
		//시분초 입력받아 분만 출력하기
//		String time = "11:1:12";
//		String [] result = time.split(":");
//		if(result[1].length()==1) {
//			result[1] = "0" + result[1];
//		}
//		System.out.println(result[1]);
		
		//년월일 입력 받아 형식 바꿔 출력하기
		String birth = "2014.07.15";
		birth = birth.replace(".", "-");
		String [] result = birth.split("-");
		System.out.printf("%s-%s-%s",result[2],result[1],result[0]);
	}

}
