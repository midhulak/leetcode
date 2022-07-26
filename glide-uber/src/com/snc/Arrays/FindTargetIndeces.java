package com.snc.Arrays;

public class FindTargetIndeces {
	
	/** https://leetcode.com/explore/interview/card/uber/289/array-and-string/1683/
	/**
	 * 34. Find First and Last Position of Element in Sorted Array
Medium

9534

273

Add to List

Share
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
	 * @param args
	 */
	
	  public int[] searchRange(int[] nums, int target) {
	        
	      int leftIndex = getStartingIndex(nums , target);
	        int rightIndex = getEndingIndex(nums , target);
	        
	        
	        return new int[]{leftIndex , rightIndex};
	        
	    }
	    
	    public int getStartingIndex(int[] nums , int target){
	        
	        int low=0;
	        int high = nums.length-1;
	        int index=-1;
	        
	        while(low <= high){
	            int mid = low + (high - low)/2;
	            
	            if(nums[mid] >= target)
	                high = mid-1;
	            else
	                low=mid+1;
	            
	            if(nums[mid] == target)
	               index= mid;
	            
	        }
	        return index;
	    }
	    
	    
	    public int getEndingIndex(int[] nums , int target){
	        int low=0;
	        int high = nums.length-1;
	        int index=-1;
	        
	        while(low <= high){
	            
	            int mid = low+(high-low)/2;
	            
	            if(nums[mid] <= target)
	                low=mid+1;
	            
	            else
	                high = mid-1;
	            
	            if(nums[mid] == target)
	                index= mid;
	        }
	        return index;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
