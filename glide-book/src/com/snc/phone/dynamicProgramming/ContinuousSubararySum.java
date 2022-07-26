package com.snc.phone.dynamicProgramming;

import java.util.HashMap;

public class ContinuousSubararySum {
	
	 public boolean checkSubarraySum(int[] nums, int k) {
	        
		 int sum =0;
		         HashMap<Integer , Integer> map = new HashMap<>();
		         map.put(0,-1);
		         for(int i=0 ; i< nums.length; i++){
		             sum+=nums[i];
		             
		             if(k != 0)
		                 sum=sum%k;
		             
		             if(map.containsKey(sum)){
		                 
		                 if(i-map.get(sum) > 1)
		                     return true;
		             }
		             else
		                 map.put(sum , i);
		             
		         }
		         return false;
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {23,2,4,6,7};
		int k = 6;
		
		ContinuousSubararySum c = new ContinuousSubararySum();
		c.checkSubarraySum(nums, 6);

	}

}
