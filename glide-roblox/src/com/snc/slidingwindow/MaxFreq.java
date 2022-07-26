package com.snc.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
	
	/**
	 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
	 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:

Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
Explanation: Substring "aab" has 2 ocurrences in the original string.
It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
Example 2:

Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
Output: 2
Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 
	 * @param args
	 */

	
	 public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
	        //we can use sliding window pointers here unique characters in a string is not greater tahn maxletters and size of string in between minsize and maxsize
	        
	        
	     int[] ch = new int[26];
	        Map<String , Integer> map = new HashMap<>();
	        int uniqueChars=0;
	        
	        int numOcc = 0;

	        int j=0;
	        
	        for(int i=0; i< s.length(); i++){
	            
	          
	            
	            if(++ch[s.charAt(i)-'a'] == 1)
	                uniqueChars++;
	            
	            while(uniqueChars > maxLetters || i-j+1 > maxSize){
	                
	                if(--ch[s.charAt(j) - 'a'] == 0)
	                    uniqueChars--;
	                j++;
	            }
	            
	            while(i-j+1 >= minSize){
	                
	                String s1 = s.substring(j,i+1);
	                map.put(s1, map.getOrDefault(s1,0)+1);
	                
	                numOcc = Math.max(numOcc , map.get(s1));
	                
	                 if(--ch[s.charAt(j) - 'a'] == 0)
	                    uniqueChars--;
	                
	                j++;
	                
	            }
	                
	        }
	        
	        return numOcc;
	    }
		 
		 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
