package com.snc.Arrays;

public class DistinctEvenPairSum {
	
	public int getDistinctPair(int[] nums){
		int len = nums.length;
		int count1=0,counter2=0;
		int[] a = new int[input.length+2];
		for(int i=0;i<nums.length;i++){
		a[i]=nums[i-1];
		}
		int n = nums.length;
		a[n+1]=a[1];
		for(int i=1;i<=len-1;i++){
		if((a[i] & 1) == a[i+1) & 1)){
		counter1++;
		i++;
		}
		}
		for(int i=2;i<=len;i++){
		if((a[i] & 1) == a[i+1) & 1)){
		counter2++;
		i++;
		}
		}
		if(counter1>counter2)
		return counter1;
		return counter2;

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
