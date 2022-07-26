package com.snc.phone.dynamicProgramming;

/**
 *  /*\
    Time complexity : O(n^2)O(n 
2
 ). Since expanding a palindrome around its center could take O(n)O(n) time, the overall complexity is O(n^2)O(n 
2
 ).

Space complexity : O(1)O(1).

**/

public class LongestPalindromicSubstring {
	
	 public String longestPalindrome(String s) {
	        
	        if(s == null || s.length() < 1)
	            return null;
	        
	        int st = 0;
	        int end =0;
	        
	        for(int i=0; i<s.length(); i++){
	            int odd = expandBothSides(s , i ,i);
	            int even = expandBothSides(s , i , i+1);
	            
	            int maxLen = Math.max(odd , even);
	            
	            if(maxLen > end-st){
	                 st = i - ((maxLen -1)/2);
	                 end = i+ (maxLen/2);
	            }
	        }
	        
	        return s.substring(st , end+1);
	    }
	    
	    
	    public int expandBothSides(String s , int left , int right){
	        
	        if(s == null || left > right)
	            return 0;
	        
	        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
	            left--;
	            right++;
	        }
	        return right-left-1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		 l.longestPalindrome("babad");
				
	}

}
