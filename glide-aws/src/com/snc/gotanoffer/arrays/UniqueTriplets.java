package com.snc.gotanoffer.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTriplets {
	
	/**
	 * Time Complexity: \mathcal{O}(n^2)O(n 
2
 ). twoSum is \mathcal{O}(n)O(n), and we call it nn times.

Sorting the array takes \mathcal{O}(n\log{n})O(nlogn), so overall complexity is \mathcal{O}(n\log{n} + n^2)O(nlogn+n 
2
 ). This is asymptotically equivalent to \mathcal{O}(n^2)O(n 
2
 ).

Space Complexity: \mathcal{O}(n)O(n) for the hashset.
	 * @param nums
	 * @return
	 */
	
//  public List<List<Integer>> threeSum(int[] nums) {
//  Arrays.sort(nums);
//  List<List<Integer>> triplets = new ArrayList<List<Integer>>();


//for(int i=0 ; i< nums.length-2; i++) {
	
//	int left = i+1;
//	int right = nums.length-1;
	
//	while(left < right) {
//	int currentSum = nums[i]+nums[left]+nums[right];
	
//	if(currentSum == 0) {
		
//      List<Integer> triple = new ArrayList<Integer>();
//	    triple.add(nums[i]);
//      triple.add(nums[left]);
//      triple.add(nums[right]);
		
//		triplets.add(triple);
//		left++;
//		right--;
//	}
	
//	else if(currentSum > 0) {
//		right --;
		
//	}
	
//	else if(currentSum < 0) {
//		left++;
//	}
		
	
//	}
	
//}


//return triplets;
 
//}


public List<List<Integer>> threeSum(int[] nums) {
Arrays.sort(nums);
List<List<Integer>> res = new ArrayList<>();
for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
 if (i == 0 || nums[i - 1] != nums[i])
     twoSumII(nums, i, res);
return res;
}
void twoSumII(int[] nums, int i, List<List<Integer>> res) {
int lo = i + 1, hi = nums.length - 1;
while (lo < hi) {
 int sum = nums[i] + nums[lo] + nums[hi];
 if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1]))
     ++lo;
 else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
     --hi;
 else
     res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
