package com.snc.facebook.phone;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringatmostKcharacters {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //sliding window approach shrinking and expanding..if it is not continuos need to use map and check whether teh indeces of i is  same or not
        
        if(s== null || s.length() == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        
        Map<Character ,Integer> map = new HashMap<>();
        
        int i=0;
        int j=0;
        while(j < s.length()){
            
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j) , j);
            }
            else{
                map.put(s.charAt(j) , j);
                k--;
            }
            
             while(k < 0 && i <= j){
            
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == i){
                map.remove(s.charAt(i));
                i++;
                k++;
            }
            else if(map.containsKey(s.charAt(i))){
                i++;
            }
            
        }
            
            max=Math.max(max , j-i+1);
        
        j++;
        
     
            
        }
        
       
        return max == Integer.MIN_VALUE ? -1 : max;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
