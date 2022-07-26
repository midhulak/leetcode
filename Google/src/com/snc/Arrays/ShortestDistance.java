package com.snc.Arrays;

public class ShortestDistance {
	
	public static int[] shortestToChar1(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) 
            	prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

	
	public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int[] compareIndex = new int[s.length()];
        int j=0;
        
        for(int i=0 ; i<s.length(); i++){
            if(s.charAt(i) == c){
                compareIndex[j] = i;
                j++;
            }
        }
        
        int k=0;
        
        for(int l=0; l<s.length(); l++){
            
            if(s.charAt(l) == c)
                result[l] = 0;
            
            else{
                int min = Integer.MAX_VALUE;
                k=0;
                while(k<=j-1){
                   min=Math.min(min , Math.abs(compareIndex[k] - l)) ;
                    k++;
                }
                result[l] = min;
            }
            
        }
        
        return result;
        
    }
	
	public static void main(String[] args) {
		
		int[] res =shortestToChar1("loveleetcode" , 'e');
		for(int i=0 ; i<res.length; i++) {
			System.out.println("result is="+res[i]);
		}
		
	}
}
