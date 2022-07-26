package com.snc.arrays;
/*https://leetcode.com/problems/count-number-of-nice-subarrays/ 
 * 1248. Count Number of Nice Subarrays
Medium

1670

42

Add to List

Share
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There is no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 */
public class CountNiceSubArrays {
	
	   public int numberOfSubarrays(int[] nums, int k) {
	        int [] dp = new int[nums.length+1];
	        dp[0] = 1;
	        int res = 0;
	        int sum = 0;
	        for (int right=0; right<nums.length; right++) {
	            sum += nums[right] % 2;
	            dp[sum]++;
	            //if we get k number of odd's that means we found some subarray which has k odd numbers, before that if not k numbers it is all 0 those we added in 0 so those many combinations(which are evens) we can add to get k odd numbers , similarly after that how many k odd numbers we find before that level how many times evens present those many combinations we can add 
	            if (sum-k>=0)
	                res += dp[sum - k];
	        }
	        return res;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
