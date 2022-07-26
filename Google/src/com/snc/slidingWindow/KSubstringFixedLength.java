package com.snc.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class KSubstringFixedLength {
	
	//K substring of fixed length in a string
	
	  public static int numKLenSubstrNoRepeats(String S , int K){
	        
	        Set<String> set = new HashSet<String>();
	        
	        int j=0;
	        int res=0;
	        
	        for(int i=0 ; i<S.length(); i++){
	            
	            while(set.contains(S.charAt(i) + "")){
	              set.remove(S.charAt(j)+"");
	                j=j+1;
	               }
	                  
	                  set.add(S.charAt(i)+"");
	                   if(set.size() > K){
	                       set.remove(S.charAt(j)+"");
	                       j=j+1;
	                   
	                   }
	            
	            if(set.size() == K)
	                res++;
	                   } 
	                 return res;
	                  }
	                  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Input: S = "havefunonleetcode", K = 5
Output: 6
Explanation: 
There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
		 */
		
		System.out.println(numKLenSubstrNoRepeats("havefunonleetcode" , 5));

	}

}
