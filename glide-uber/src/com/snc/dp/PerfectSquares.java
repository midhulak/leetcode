package com.snc.dp;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {
	
	  /**Recursion **/
	   /** https://www.youtube.com/watch?v=1xfx6M_GqFk **/
	    public int numSquaresR(int n) {
	        //recursion
	        Map<Integer , Integer> map = new HashMap<>();
	        int ans = numSquaresRec(n , map);
	        return ans;
	        
	    }
	    
	    
	    public int numSquaresRec(int n , Map<Integer , Integer> map){
	        
	        if(map.containsKey(n))
	            return map.get(n);
	        
	        if(n <= 3)
	            return n;
	        int ans = n;
	        
	        for(int i=1; i*i<=n ; i++){
	            
	            ans = Math.min(ans , 1+numSquaresRec(n- i*i , map) );
	            
	            map.put(n , ans);
	        }
	        
	        return ans;
	    }
	    
	    
	    //Dp
//	     for eg need to find squares
	        
//	         0 1 2 3 4 5 6 7 8
//	     ->  0 1 2 3 4 5 6 7 8
//	     ->  0 1 2 3 1 2 3 4 2
	    
	    public int numSquares(int n){
	        
	        int[] dp = new int[n+1];
	        
	       
	        for(int i=1; i<=n; i++){
	            dp[i] = i;
	            
	            for(int j=1; j*j<=i; j++){
	                int sq = j*j;
	                dp[i] = Math.min(dp[i] , 1+dp[i - sq]);
	            }
	        }
	        
	        return dp[n];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
