package level1;

import java.util.Iterator;

public class Keypad {

	public static void main(String[] args) {
		
		String answer = "";
		String hand = "left";
		int left = 10; 
		int right = 12;
		
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		for (int i = 0; i < numbers.length; i++) {
			switch(numbers[i]){
				case 1: case 4: case 7:
					answer += "L";
					left = numbers[i];
					break;
				case 3: case 6: case 9:
					answer += "R";
					right = numbers[i];
					break;
				case 2: case 5: case 8: 
					int x = 0;
					int y = 0;
					x = Math.abs(numbers[i] - left);
					y = Math.abs(numbers[i] - right);
					System.out.println("확인" + x+","+y);
					if(x == y) {
						if(hand.equals("left")) {
							answer += "L";
							left = numbers[i];
						}else {
							answer += "R";
							right = numbers[i];
						}
					}else if(x > y) {
						answer += "R";
						right = numbers[i];
					}else {
						answer += "L";
						left = numbers[i];
					}
					break;
				case 0:
			}
		}
		
		System.out.println(answer);
	}
}
