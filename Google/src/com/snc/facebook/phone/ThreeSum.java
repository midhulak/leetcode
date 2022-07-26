package com.snc.facebook.phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
	  public List<List<Integer>> threeSum(int[] nums) {
	      
	         Arrays.sort(nums);
	         List<List<Integer>> result = new LinkedList();
	         
	         for(int i=0 ; i<nums.length; i++){
	             
	             if( i == 0 || (i>0 && nums[i-1] != nums[i])){
	                 
	                 int left = i+1;
	                 int right = nums.length-1;
	                 
	                 while(left < right){
	                     
	                     int sum = nums[i]+nums[left]+nums[right];
	                     
	                     if(sum == 0){
	                         result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
	                     
	                     while(left < right && nums[left] == nums[left+1])
	                         left++;
	                     
	                     while(left < right && nums[right] == nums[right-1])
	                         right--;
	                     
	                     left++;
	                     right--;
	                     
	                     
	                 }
	                     
	                     else if(sum < 0)
	                         left++;
	                         else
	                             right--;
	                         
	                     }
	                 
	             }
	         }
	         
	         return result;
	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum t = new ThreeSum();
		int[] nums= {-1,0,1,2,-1,-4};
		t.threeSum(nums);

	}

}
