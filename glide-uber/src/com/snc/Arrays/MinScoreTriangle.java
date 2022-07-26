package com.snc.Arrays;

public class MinScoreTriangle {
	
	 //https://www.youtube.com/watch?v=SlTPS9CF9hA
	//https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
	   // when triangle forms get that and look for possiblities from in between i to j and k is running loop always get multiply of i*k*j + clal(i,j) +call(j)
	      int min = Integer.MAX_VALUE;
	    public int minScoreTriangulation(int[] values) {

	        
	        int n = values.length;
	        int[][] dp = new int[n][n];
	        
	        for(int d =2 ; d < n; d++){
	            for(int i=0; i+d <n ; i++){
	                
	                int j= i+d;
	                dp[i][j] = Integer.MAX_VALUE;
	                for(int k=i+1; k <j ; k++)
	                {
	                    dp[i][j] = Math.min(dp[i][j] , dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
	                }
	            }
	        }
	        
	        return dp[0][n-1];
	    }
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
