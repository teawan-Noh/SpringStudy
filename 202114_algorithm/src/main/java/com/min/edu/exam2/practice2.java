package com.min.edu.exam2;

import java.util.HashSet;
import java.util.Set;

public class practice2 {

	public boolean solution(int[] arr, int n) { //5, 3 ,9, 13
		boolean isc = false;
		int len = arr.length;
		
		//set 중복값이 없고 , 순서가 없음 출력 Iterator를 사용
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < len; i++) {
			int val = n - arr[i]; // ex) 8 - 5 -> 3
			if(set.contains(val)) {
				isc = true;
				break;
			}
			set.add(arr[i]);
		}
		
		return isc;
	}
}
