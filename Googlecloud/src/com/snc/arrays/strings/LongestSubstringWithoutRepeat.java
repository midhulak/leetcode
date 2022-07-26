package com.snc.arrays.strings;

public class LongestSubstringWithoutRepeat {
	
	//TC: O(n) SC: O(1)
	 public static int lengthOfLongestSubstring(String s) {
	        int ans=0;
	        int n = s.length();
	        int[] letters = new int[26];
	        
	        int i=0;
	        for(int j=0 ; j <n; j++ ){
	            
	            i = Math.max(letters[s.charAt(j) - 'a'] , i);
	            ans = Math.max(ans , j-i+1);
	            letters[s.charAt(j) - 'a']= j+1; //every time update teh characters you visited so that i will set to 
	            //number which has updated.
	            
	        }
	        
	        return ans;
	    }
	 
	 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abdgggfdsrtb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
}