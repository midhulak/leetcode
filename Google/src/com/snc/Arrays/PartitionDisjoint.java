package com.snc.Arrays;

public class PartitionDisjoint {
	//leet code 915
//	Input: nums = [5,0,3,8,6]
//			Output: 3
//			Explanation: left = [5,0,3], right = [8,6]
	
	 public int partitionDisjoint(int[] nums) {
	        //find out max in left 
	        //find out min in right
	        
	        //if(max element in left < min element in right then it satisfies all conditions)
	        int n = nums.length;
	        int[] leftMax = new int[nums.length];
	        int[] rightMin = new int[nums.length];
	        
	        int min=Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        
	     
	        
//	         for(int i=0; i< nums.length; i++){
	 //             if(nums[i] > max){
//	                 max=nums[i];
//	             }
//	                 leftMax[i] = max;
	 //         }
//	          for(int i=nums.length-1; i>=0; i--){
	 //             if(nums[i] < min){
//	                 min=nums[i];
//	             }
//	                 rightMin[i] = min;
//	         }
	        
	           rightMin[n-1]=nums[n-1];
	        leftMax[0] = nums[0];
	        
	        for(int i=1 ; i<n; i++){
	            leftMax[i] = Math.max(leftMax[i-1] , nums[i]);
	            rightMin[n-i-1] = Math.min(rightMin[n-i] , nums[n-1-i]);
	        }
	        
	        for(int i=0; i<nums.length-1; i++){
	            
	            if(leftMax[i] <= rightMin[i+1])
	                return i+1;
	        }
	        return 0;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
