package com.snc.sorting;

public class GroupTheNumbers {
	
	
	public static int[] groupNumbers(int[] arr) {
		
		 int left=0 ; int right= arr.length-1;
		 
		 while(left <= right) {
			 
			 if(arr[left]%2 == 1) {
				 
				 int tmp = arr[right];
				 arr[right] = arr[left];
				 arr[left] = tmp;
				 right--;
			 }
			 
			 else
				 left++;
			 
		 }
		 
		 return arr;
	       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {8,4,9,5,2,9,5,7,10};
		
		int[] res = groupNumbers(arr);
		
		for(int i=0 ; i<res.length; i++) {
			System.out.println("res is="+res[i]);
		}
		

	}

}
