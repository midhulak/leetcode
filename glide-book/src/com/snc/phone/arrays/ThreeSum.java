package com.snc.phone.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
	
	 //Time Complexity: \mathcal{O}(n^2)O(n 
			// 2
			//  ). twoSumII is \mathcal{O}(n)O(n), and we call it nn times.

			// Sorting the array takes \mathcal{O}(n\log{n})O(nlogn), so overall complexity is \mathcal{O}(n\log{n} + n^2)O(nlogn+n 
			// 2
			//  ). This is asymptotically equivalent to \mathcal{O}(n^2)O(n 
			// 2
			//  ).

			// Space Complexity: from \mathcal{O}(\log{n})O(logn) to \mathcal{O}(n)O(n), depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, we ignore the memory required for the output.


			    //without duplicates
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
			     
			     public List<List<Integer>> threeSumWithDuplicates(int[] nums) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
