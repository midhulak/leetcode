package com.snc.day6.sorting;

public class BubbleSort {
//if first element is greater than next element swap
	
	
public static  int[] bubbleSort(int[] array) {
	
	//Best O(n) | O(1) space
	//Average O(n^2) | O(1) space
	//Worst O(n^2) | O(1) space
		
		if(array.length == 0) {
			return new int[] {};
		}
		
		boolean isSorted = false;
		int counter=0;
		while(!isSorted) {
			isSorted = true;
			
			for(int i=0 ; i<array.length-1-counter; i++) {
				
				if(array[i] > array[i+1]) {
					swap(i, i+1,array);
					isSorted=false;
				}
			}
			counter++;
		}
		return array;
	}
	
	
	public static void swap(int i , int j , int[] array) {
		
		int temp = array[i];
		array[j] = array[i];
		array[i] = temp;
	}
	
	
	public static int[] bubbleSort(int[] array) {
		if(array.length == 0) {
			return new int[] {};
		}
		
		boolean isSorted = false;
		int counter=0;
		while(!isSorted) {
			isSorted = true;
			for(int i=0 ; i<array.length-1-counter; i++) {
				if(array[i] > array[i+1]) {
					swap(i , i+1 , array);
					isSorted =false;
				}
			}
			counter++;
		}
	}
	
	public static  void swap(int i , int j, int[] array) {
		int temp=array[i];
		array[i] = array[j];
		array[j] = temp;	
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
