package com.snc.arrays.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringatmost2Characters {
	/**
	 *  /**
    For the best case when input string contains not more than k distinct characters the answer is yes. It's the only one pass along the string with N characters and the time complexity is \mathcal{O}(N)O(N).

For the worst case when the input string contains n distinct characters, the answer is no. In that case at each step one uses \mathcal{O}(k)O(k) time to find a minimum value in the hashmap with k elements and so the overall time complexity is \mathcal{O}(N k)O(Nk).

Time complexity : \mathcal{O}(N)O(N) in the best case of k distinct characters in the string and \mathcal{O}(N k)O(Nk) in the worst case of N distinct characters in the string.

Space complexity : \mathcal{O}(k)O(k) since additional space is used only for a hashmap with at most k + 1 elements.

**/
	 * @param s
	 * @param k
	 * @return
	 */
	
public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        Map<Character , Integer> map = new HashMap<>();
        
        int i=0;
        int j=0;
        int max = 0;
        
        while(j < s.length()){
            
            map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) , 0)+1);
            
            
            while(map.size() > k && i<=j){
                //remove the elements until the hashmap size is 2 
                
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >=1){
                    
                    map.put(s.charAt(i) , map.get(s.charAt(i)) - 1);
                    
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                    
                }
            }
            //get the length of string when hashmap size is 2
             max= Math.max(max, j-i+1);
            j++;
        }
        
        return max;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
