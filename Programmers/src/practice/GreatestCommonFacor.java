package practice;

public class GreatestCommonFacor {

	public static void main(String[] args) {
		
		int a = 32;
		int b = 12;
		int c = 0;
		
		
		while(b!=0) {
			c = b;
			b = a % b;
			a = c;
			System.out.println("a: " + a+ " b:" + b+ " c: " +c);
		}
		System.out.println(a);

		
	}

}
