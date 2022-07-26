package com.snc.phone.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	
	   /**
	    * 
	    * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    Time complexity : \mathcal{O}(N)O(N) in the best case of k distinct characters in the string and \mathcal{O}(N k)O(Nk) in the worst case of N distinct characters in the string.

Space complexity : \mathcal{O}(k)O(k) since additional space is used only for a hashmap with at most k + 1 elements.
*/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if(s.length() == 0 || s == null)
            return 0;
        
        Map<Character , Integer> map = new HashMap<>();
        
        int i=0;
      
        int max = 0;
        
        for(int j=0; j < s.length(); j++){
            
            map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) , 0)+1);
            
            
            while(map.size() > k ){
                
                //will check each i if we remove any character still it remains the same size of k then we can add those into list
                //if we remove i form map then need to increment i and repeat the same .
                if( i<=j && map.get(s.charAt(i)) > 0)
                    map.put(s.charAt(i) , map.get(s.charAt(i)) - 1);
                
                    
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                   
                
            i++;
                    
                }
               
             
              
             max= Math.max(max, j-i+1);
            }
            
              
           return max;  
        }
        
       

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
