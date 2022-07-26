package com.snc.onsite.set1;

import java.util.HashMap;
import java.util.Map;

public class calculateTime {
	
	 public int calculateTime(String keyboard, String word) {
	        
	        Map<Character , Integer> map = new HashMap<>();
	        
	        for(int i=0; i<keyboard.length(); i++){
	            
	            map.put(keyboard.charAt(i) , i);
	        }
	        
	        int count =0;
	        int prevIndex =0;
	        int currIndex =0 ;
	        
	        for(int i=0; i<word.length(); i++){
	            
	            char ch  = word.charAt(i);
	            currIndex = map.get(ch) != null ? map.get(ch) : 0;
	          
	            count+= Math.abs(currIndex - prevIndex);
	            
	            prevIndex = currIndex;
	                
	           
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
