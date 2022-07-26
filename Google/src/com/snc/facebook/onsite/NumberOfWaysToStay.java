package com.snc.facebook.onsite;

public class NumberOfWaysToStay {
	
	 int MOD = 1000000007;
	    long[][] dp;
	    public int numWays(int steps, int arrLen) {
	        int range = Math.min(steps , arrLen);
	        dp = new long[steps+1][range+1];
	        return DFS(0 , steps , range);
	        
	    }
	    
	    
	   public  int DFS(int i , int steps , int len){
	        if(i < 0 || i >= len || steps < 0 || i > steps)
	            return 0;
	        
	        if (steps == 0 && i== 0)
	            return 1;
	        
	        if(steps==0)
	            return 0;
	        
	        if(dp[steps][i] != 0)
	            return (int)dp[steps][i];
	        
	        long result =  ((DFS(i+1 , steps-1 , len) + DFS(i-1 , steps-1 , len)) % MOD + DFS(i, steps-1, len) % MOD);
	        
	        dp[steps][i] = result;
	        return (int) result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
