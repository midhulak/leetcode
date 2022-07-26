package com.snc.okta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
  public List<List<Integer>> threeSum1(int[] nums) {
  Arrays.sort(nums);
  List<List<Integer>> triplets = new ArrayList<List<Integer>>();


for(int i=0 ; i< nums.length-2; i++) {
	
	int left = i+1;
	int right = nums.length-1;
	
	while(left < right) {
	int currentSum = nums[i]+nums[left]+nums[right];
	
	if(currentSum == 0) {
		      List<Integer> triple = new ArrayList<Integer>();
	    triple.add(nums[i]);
      triple.add(nums[left]);
      triple.add(nums[right]);
		
		triplets.add(triple);
		left++;
		right--;
	}
	
	else if(currentSum > 0) {
		right --;
		
	}
	
	else if(currentSum < 0) {
		left++;
	}
		
	
	}
	
}


return triplets;
 
}


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

	}

}
