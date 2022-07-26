package com.snc.square;
import java.util.ArrayList;
import java.util.List;

public class PanCakeSorting {
	
	public static List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<>();
		int end = A.length;
		while (end != 1) {
			int index = find(A, end);
			flip(A, index);
			flip(A, end - 1);
			list.add(index + 1);
			list.add(end);
            end--;
		}
		return list;
	}


	private static int find(int[] A, int target) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private static void flip(int[] A, int end) {
		int start = 0;
		while (start < end) {
			int temp = A[start];
			A[start++] = A[end];
			A[end--] = temp;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,4,1};
		
		pancakeSort(A);

	}

}
