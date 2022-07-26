package com.snc.dp;

import java.util.Arrays;

public class MaxEnvelopes {
	/*https://www.youtube.com/watch?v=mouCn3CFpgg*/
	
	 public int maxEnvelopes(int[][] envelopes) {
	        
	        if(envelopes.length == 0)
	            return 0;
	        
	        Arrays.sort(envelopes , (i1,i2)->Integer.compare(i1[0] , i2[0]));
	        
	        int[] maxEnv = new int[envelopes.length];
	       
	        maxEnv[0]=1;
	        
	        int max = 1;
	        
	        for(int i=1; i<envelopes.length; i++){
	            maxEnv[i] = 1;
	            
	            for(int j=0; j<i; j++){
	                
	                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && maxEnv[i] <= maxEnv[j]){
	                    
	                     maxEnv[i] = maxEnv[j]+1;
	                    
	                    max = Math.max(max, maxEnv[i]);
	                }
	            }
	        }
	        
	        return max;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
