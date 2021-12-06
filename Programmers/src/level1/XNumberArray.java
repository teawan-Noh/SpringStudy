package level1;

public class XNumberArray {

	public static void main(String[] args) {
		long x = -4;
		int n = 3;
		
		long[] arr = new long[n];
		arr[0] = x;
		
		
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i-1] + x;
			System.out.println(arr[i-1]);
		}

	}

}
