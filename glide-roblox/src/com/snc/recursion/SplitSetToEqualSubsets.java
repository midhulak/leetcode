package com.snc.recursion;

import java.util.HashMap;

public class SplitSetToEqualSubsets {
	
	  public boolean canPartition(int[] nums) {
	        int total =0;
	        for(int num : nums){
	            total+=num;
	        }
	        
	        if(total%2 != 0)
	            return false;
	        
	       return canPartition(nums , total , 0 , 0 , new HashMap<String,Boolean>());
	    }
	    
	    public boolean canPartition(int[] nums , int total , int index , int sum , HashMap<String , Boolean> map){
	        
	        String key = index+"#"+sum;
	        
	        if(map.containsKey(key))
	            return map.get(key);
	        if(sum *2 == total)
	            return true;
	        
	    if(sum > total || index >= nums.length)
	        return false;
	        
	        //include the number adn other exclude the number to the sum
	        
	       boolean found =canPartition(nums,total ,index+1, sum , map) || canPartition(nums , total , index+1 , sum+nums[index] , map);
	        map.put(key , found);
	        
	        return found;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
