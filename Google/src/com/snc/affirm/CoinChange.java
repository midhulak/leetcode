package com.snc.affirm;

import java.util.Arrays;

public class CoinChange {

	
	 public int coinChange1(int[] coins , int amount){
	        
         int[] denoms = new int[amount+1];
        
        Arrays.fill(denoms , Integer.MAX_VALUE);
        
        denoms[0]=0;
        int j=0;
        int toCompare=0;
        
      while(j < coins.length){
          
          
          for(int i=0 ; i<denoms.length; i++){
              
              if( coins[j] <= i){
                  
                  if( denoms[i - coins[j] ] == Integer.MAX_VALUE){
                      
                      toCompare = denoms[ i - coins[j] ];
                  }
                  else{
                      toCompare = 1 + denoms[ i - coins[j] ];
                  }
                  denoms[i] = Math.min(denoms[i] , toCompare);
              }
              
             
          }
          j++;
      }
        return denoms[amount] != Integer.MAX_VALUE ? denoms[amount] : -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
