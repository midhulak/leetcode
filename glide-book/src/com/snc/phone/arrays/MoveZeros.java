package com.snc.phone.arrays;

public class MoveZeros {
	
	 //Space Complexity : O(1)O(1). Only constant space is used.

	//Time Complexity: O(n)O(n). However, the total number of operations are still sub-optimal. The total operations (array writes) that code does is nn (Total number of elements).
	//https://leetcode.com/problems/move-zeroes/solution/
	
public void moveZeroes(int[] nums) {
        
        int i=0;
        int j=0;
        
      while( j < nums.length && i <= j){
          //move all non zeros to the left so zeros will come to the right
          if(nums[j] != 0){
              swap(nums , i,j);
             i++;
          }
          j++;
      }
        
        
    }
    
    public void swap(int[] nums , int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
