package Google;

import java.util.ArrayList;
import java.util.List;

public class RotatedSlidingWindow {
	public static int maxSlidingWindow(int[]arr, int k) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int sum = 0;
		int j = arr.length - 1;
		List<Integer>list = new ArrayList<>();
		int i = 0;
		while(i < arr.length) {
			if(k > 0) {
				if(arr[i] < arr[j]) {
					sum += arr[j];
					j--;
					k--;
					list.add(arr[j]);
				} else {
					sum += arr[i];
					i++;
					k--;
					list.add(arr[i]);
				}
			} else {
				break;
			}
		}
		for(Integer l : list) {
			System.out.println("list : " + l);
		}
		return sum;
	}
	public static void main(String[]args) {
		int[]arr = {-2, -1, 9, 0, -3, -4, 4};
		int[]arr1 = {-12, 1, 15, -6, 10, 10, 0, -3, 4, 4};
		int[]arr2 = {0, 1, 2, 3, 6, 4};
		System.out.println(maxSlidingWindow(arr, 4));
		System.out.println(maxSlidingWindow(arr1, 3));
		System.out.println(maxSlidingWindow(arr2, 3));
	}
}
