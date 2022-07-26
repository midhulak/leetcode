package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	 public int[] twoSum(int[] nums, int target) {
	        
	        Map<Integer , Integer> map = new HashMap<>();
	        
	       
	        
	      for(int i=0; i<nums.length; i++){
	          
	          if(map.containsKey(target-nums[i])){
	              
	              return new int[]{i , map.get(target-nums[i])};
	          }
	          map.put(nums[i] , i);
	      }
	        return null;
	    }
	 
	 public int[] twoSum1(int[] nums, int target) {
	        
	       int[] result = new int[2];
	       
	       for(int i=0; i < nums.length; i++){
	          
	           for(int j=0; j < nums.length; j++){
	              
	               if(i == j)
	                   continue;
	              
	               if(nums[i] + nums[j] == target){
	                    result[0] = i;
	                     result[1] = j;
	                   return result;
	           }
	           }
	       }
	       return result; 
	   }
	 
	 public int[] twoSum3(int[] nums, int target) {
	        
	       int[] result = new int[2];
	       
	       for(int i=0; i < nums.length; i++){
	          
	           for(int j=0; j < nums.length; j++){
	              
	               if(i == j)
	                   continue;
	              
	               if(nums[i] + nums[j] == target){
	                    result[0] = i;
	                     result[1] = j;
	                   return result;
	           }
	           }
	       }
	       return result; 
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
