package com.snc.slidingWindow;

public class MaxSubArraySizeK {
	

	public static int findMaxSumSubArray(int k , int[] arr) {
		int i=0; int j=0;
		int sum=0;
		int max = Integer.MIN_VALUE;
		for(i=0; i<arr.length; i++)
		{
			sum+=arr[i];
			
			if(i >= k-1) {
			max= Math.max(max, sum);
			sum-=arr[j];
			j++;
			}
		}
		
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
