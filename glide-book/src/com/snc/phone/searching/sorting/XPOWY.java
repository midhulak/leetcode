package com.snc.phone.searching.sorting;

public class XPOWY {
	//https://leetcode.com/problems/powx-n/solution/
	 //Time complexity : O(n)O(n). We will multiply x for n times.

	//Space complexity : O(1)O(1). We only need one variable to store the final product of x.

	     private double fastPow(double x, long n) {
	        if (n == 0) {
	            return 1.0;
	        }
	        double half = fastPow(x, n / 2);
	        if (n % 2 == 0) {
	            return half * half;
	        } else {
	            return half * half * x;
	        }
	    }
	    public double myPow(double x, int n) {
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }

	        return fastPow(x, N);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
