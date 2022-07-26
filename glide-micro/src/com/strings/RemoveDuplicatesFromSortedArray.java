package com.strings;

public class RemoveDuplicatesFromSortedArray {
	
	 public int removeDuplicates(int[] nums) {
	        
	        if(nums.length <= 1)
	            return 1;
	        
	    int left =0;
	        while(nums[left] < nums[left+1])
	            left++;
	        
	        for(int curr=left+1; curr<nums.length-1; curr++){
	            
	            while(nums[curr] == nums[curr+1])
	                curr++;
	            
	            swap(left , curr , nums);
	            left++;
	            
	        }
	        
	        
	        return left+1;
	    }
	    
	    public void swap(int left , int curr , int[] nums){
	        
	        int temp = nums[left];
	        nums[left] = nums[curr];
	        nums[curr] = temp;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
