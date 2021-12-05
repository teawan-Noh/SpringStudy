package level1;

import java.util.Scanner;
//직사각형 별찍기
public class Star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		int b = sc.nextInt();
//		int a = sc.nextInt();
		int a = 5;
		int b = 3;
		
		for (int j = 0; j < b; j++) {
			for (int i = 0; i < a; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
