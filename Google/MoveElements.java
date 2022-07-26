package Google;

import java.util.Arrays;

public class MoveElements {
	public static int[] moveTarget(int[]arr, int target) {
		int index = arr.length - 1;
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] != target) {
				arr[index] = arr[i];
				index--;
			}
		}
		while(index >= 0) {
			arr[index] = target;
			index--;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 4, 2, 5, 7, 3, 7, 3, 5 };
		int target1 = 5;
		System.out.println(Arrays.toString(moveTarget(nums1, target1)));
		int[] nums2 = { 1, 2, 4, 2, 5, 5, 5, 5, 5, 7, 3, 7, 3, 5 };
		int target2 = 5;
		System.out.println(Arrays.toString(moveTarget(nums2, target2)));
		int[] nums3 = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		int target3 = 5;
		System.out.println(Arrays.toString(moveTarget(nums3, target3)));
		int[] nums4 = { 1, 2, 3, 4, 6, 7, 8, 9 };
		int target4 = 5;
		System.out.println(Arrays.toString(moveTarget(nums4, target4)));
	}

}
