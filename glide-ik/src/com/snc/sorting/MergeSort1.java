package com.snc.sorting;

import java.util.Arrays;

public class MergeSort1 {
	
	public static int[] mergeSort(int[] array) {
		
		if(array.length <= 1)
			return array;
		
		int middleIdx = array.length/2;
		int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
		int[] rightHalf = Arrays.copyOfRange(array, middleIdx, array.length);
		
		return mergeSortedArrays(mergeSort(leftHalf) , mergeSort(rightHalf));
		
		
	}
	
	public static int[] mergeSortedArrays(int[] leftHalf , int[] rightHalf) {
		
		int[] sortedArray = new int[leftHalf.length + rightHalf.length];
		int k=0;
		int i=0;
		int j=0;
		
		while(i<leftHalf.length && j< rightHalf.length) {
			 if(leftHalf[i] <= rightHalf[j]) {
				 sortedArray[k++] = leftHalf[i++];
			 }
			 else {
				 sortedArray[k++] = rightHalf[j++];
			 }
		}
		
		while(i < leftHalf.length) {
			sortedArray[k++] = leftHalf[i++];
		}
		
		while(j < leftHalf.length) {
			sortedArray[k++] = leftHalf[j++];
		}
		return sortedArray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {8, 5, 2, 9, 5, 6, 3};
		int[] res =mergeSort(arr);
		for(int i=0 ; i<res.length; i++) {
			System.out.println(res[i]);
		}

	}

}
