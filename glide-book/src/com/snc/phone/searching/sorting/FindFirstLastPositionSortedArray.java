package com.snc.phone.searching.sorting;

public class FindFirstLastPositionSortedArray {
	
//https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3030/
    //TC: O(logn)
    //SC: O(1)
    public int[] searchRange(int[] nums, int target) {
        //find the left index and right index 
      int leftIndex = getStartingIndex(nums , target); //in left index even though if we find the element we can say >= element still we strecth all the way to left high = mid-1
        int rightIndex = getEndingIndex(nums , target);
        ///in right index even though if we find the element we can say <= element still we strecth all the way to right low = mid+1
        
        
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
