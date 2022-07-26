package com.snc.arrays;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 * @author midhula.kadiyala
 *You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
 

Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]
 */

public class RandomPickWeight {
	
	  int[] sum;
	    Random random = new Random();
	    int max = 0;
	    public RandomPickWeight(int[] w) {
	        sum = new int[w.length];
	        sum[0] =w[0];
	        for (int i = 1; i < w.length; i++)
	            sum[i] = sum[i - 1] + w[i];
	           
	        max = sum[sum.length-1];
	    }
	    public int pickIndex() {
	        int low = 0, high = sum.length - 1;
	        int target = 1 + random.nextInt(max);
	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            if (sum[mid] == target) {
	                return mid;
	            }
	            if (sum[mid] > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return low;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
