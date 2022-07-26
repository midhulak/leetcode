package com.snc.slidingWindow;

public class MaxConsequtiveOnesKFlips {
	
	
	
	public static int printMaxones(int[] arr , int k) {
		
		int maxConsequtive=0;
		int start=0;
		
		
		for(int end=0 ; end<arr.length; end++) {
			
			if(arr[end] == 0) {
				k--;
			}
			
			while(k < 0) {
				if(arr[start] == 0)
				k++;
				
				start++;
				
			}
			
			maxConsequtive = Math.max(maxConsequtive, end-start+1);
			
		}
		return maxConsequtive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {1,1,1,0,0,0,1,1,1,1,1};
		System.out.println(printMaxones(nums , 2));
	}

}
