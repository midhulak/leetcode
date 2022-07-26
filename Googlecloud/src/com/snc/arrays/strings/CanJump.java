package com.snc.arrays.strings;

public class CanJump {
	
	//can jump to last index for every index max it goes to those many jumps , min 1 jump and max will be value at that index

	//greedy approach
	// time : O(n) //space O(1)
	public boolean canJump(int[] nums) {
		int reach =0;
		
		for(int i=0; i<=reach; i++) {
			
			reach = Math.max(reach ,  i+nums[i]);
			if(reach >= nums.length-1)
				return true;
			
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
