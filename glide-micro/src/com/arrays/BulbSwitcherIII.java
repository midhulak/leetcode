package com.arrays;

public class BulbSwitcherIII {
	
	public int bulbSwitch(int[] arr) {
		int count=0;
		
	int rightMax=-1;
	for(int i=0; i<arr.length; i++) {
		
		if(arr[i] > rightMax)
			rightMax = arr[i];
		
		if(rightMax == i+1)
			count++;
	}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
