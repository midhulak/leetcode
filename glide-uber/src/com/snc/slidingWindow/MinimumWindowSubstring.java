package com.snc.slidingWindow;

import java.util.HashMap;
import java.util.Map;


/**
 * //leetcode 76 hard

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string. 
 * @author midhula.kadiyala
 *
 */
//first try to put it in a map each character present how many times 
public class MinimumWindowSubstring {
	
	 public String minWindow(String s, String t) {
	      int maxlen = 0;
	        Map<Character , Integer> tmap = new HashMap<>();
	        Map<Character , Integer> smap = new HashMap<>();
	        int i=0;
	        int j=0;
	    Integer minOcc = Integer.MAX_VALUE;
	        String toReturn="";
	        for(int k=0; k<t.length(); k++){
	            char ch = t.charAt(k);
	            tmap.put(ch , tmap.getOrDefault(ch,0)+1);
	        }
	        
	   while(true){
	       boolean iloop = true;
	       boolean jloop =true;
	            
	            while(i < s.length() && maxlen < t.length()){
	                char ch1 = s.charAt(i);
	                smap.put(ch1 , smap.getOrDefault(ch1,0)+1);
	                
	                if(smap.getOrDefault(ch1,0) <= tmap.getOrDefault(ch1,0))
	                    maxlen++;
	                i++;
	                iloop=false;
	            }
	              
	                
	                while(j < i && maxlen == t.length()){
	                    
	                String res = s.substring(j , i);
	                    if(res.length() < minOcc){
	                        minOcc = res.length();
	                        toReturn = res; 
	                    }
	                    minOcc = Math.min(minOcc , res.length());
	                    
	                    char c1 = s.charAt(j);
	                    
	                    if(smap.get(c1) == 1)
	                        smap.remove(c1);
	                    else
	                        smap.put(c1 , smap.get(c1)-1);
	                    
	                    if( smap.getOrDefault(c1,0) < tmap.getOrDefault(c1,0)){
	                        maxlen--;
	                    }
	                    j++;
	                    
	                    jloop=false;
	                }
	       
	       if(iloop && jloop)
	           break;
	           
	   }
	           
	         return toReturn;
	            }
	            

}
