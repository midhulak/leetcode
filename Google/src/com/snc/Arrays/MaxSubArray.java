package com.snc.Arrays;

public class MaxSubArray {

public int maxSubArray(int[] nums) {
        
        int maxEnding = nums[0];
        int maxSoFar = nums[0];
        
        for(int i=1 ; i< nums.length; i++){
            
            maxEnding = Math.max(nums[i] , maxEnding+nums[i]);
            maxSoFar = Math.max(maxSoFar , maxEnding);
            
        }
        return maxSoFar;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
