package com.snc.gotanoffer.arrays;

public class BestTimeToBuyAndSellStock {
	
	   //**
//  Time complexity : O(n)O(n). Only a single pass is needed.

//Space complexity : O(1)O(1). Only two variables are used.
 public int maxProfit(int[] prices) {
     //initially set min price to max value
      int minprice = Integer.MAX_VALUE;
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length; i++) {
             //update min price from price length everytime 
	            if (prices[i] < minprice)
	                minprice = prices[i];
             //if price value is greater and diff of min price and current price is greater tahn the profit you made so far then update your profit and retrun it.
	            else if (prices[i] - minprice > maxprofit)
	                maxprofit = prices[i] - minprice;
	        }
	        return maxprofit;
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
