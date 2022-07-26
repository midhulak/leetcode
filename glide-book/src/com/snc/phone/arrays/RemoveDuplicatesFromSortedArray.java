package com.snc.phone.arrays;

public class RemoveDuplicatesFromSortedArray {
	
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/
	 * Time complextiy : O(n)O(n). Assume that nn is the length of array. Each of ii and jj traverses at most nn steps.

Space complexity : O(1)O(1).
	 * @param nums
	 * @return
	 */
	
	  public int removeDuplicates(int[] nums) {
		  
		  if(nums.length == 0)
	            return 0;
	       int i=0;
	        for(int j=1 ; j < nums.length; j++){
	            //if element is. not duplicate wiuth previous element just increment an d put the unique element.
	            if(nums[j] != nums[i])
	                i++;
	            nums[i] = nums[j];
	        }
	        return i+1;
	    }
	    

}
