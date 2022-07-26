package com.snc.phone.searching.sorting;


//https://leetcode.com/problems/find-peak-element/solution/

//Time complexity : O\big(log_2(n)\big)O(log 
//2
//​
// (n)). We reduce the search space in half at every step. Thus, the total search space will be consumed in log_2(n)log 
//2
//​
// (n) steps. Here, nn refers to the size of numsnums array.
//
//Space complexity : O(1)O(1). Constant extra space is used.


public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
        int left =0;
        
        int right = nums.length-1;
        
        while(left < right){
            
            int mid=left+(right-left)/2;
            
            if(nums[mid] < nums[mid+1])
                left = mid+1;
            
            else
                right = mid;
        }
       return left; 
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
