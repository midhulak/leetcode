package com.snc.phone.strings;

public class LongestStringWithOutRepeat {
	/*https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/ */
	
	public int lengthOfLongestSubstring(String s) {
        
	       // TC: O(n) SC: O(1)
	        int[] letters = new int[128];
	        int i=0;
	        int res=0;
	        
	        for(int j=0; j<s.length(); j++){
	            
	           i = Math.max(letters[s.charAt(j)] , i); //if we see any character which we have already visited before we are jumping ith index to that character (basically skipping that character)
	            res = Math.max(res , j-i+1);
	            letters[s.charAt(j) ] = j+1; //add the recent index you have visited that character
	            
	        }
	        
	        return res;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
