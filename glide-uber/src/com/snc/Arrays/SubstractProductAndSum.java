package com.snc.Arrays;

/* https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/ */
//
//Example 1:
//
//Input: n = 234
//Output: 15 
//Explanation: 
//Product of digits = 2 * 3 * 4 = 24 
//Sum of digits = 2 + 3 + 4 = 9 
//Result = 24 - 9 = 15
//Example 2:
//
//Input: n = 4421
//Output: 21
//Explanation: 
//Product of digits = 4 * 4 * 2 * 1 = 32 
//Sum of digits = 4 + 4 + 2 + 1 = 11 
//Result = 32 - 11 = 21
// 
public class SubstractProductAndSum {
	 public int subtractProductAndSum(int n) {
	        int sum =0;
	        int prod=1;
	       
	        while(n> 0){
	       
	            int rem = n%10;
	               n = n/10;
	            sum+=rem;
	            prod*=rem;
	        }
	        
	        return prod-sum;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
