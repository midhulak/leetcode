package com.snc.square;

public class BestTimeBuySellUnLimitedTransactions {
	
	
		   // int result=0;
		    public int maxProfit(int[] prices) {
		        
		         int maxProfit = 0;
		        for(int i=1 ; i<prices.length;i++){
		         
		          maxProfit+= Math.max(0,prices[i]-prices[i-1]);
		             
		             }
		           return maxProfit; 
		        }
		    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
