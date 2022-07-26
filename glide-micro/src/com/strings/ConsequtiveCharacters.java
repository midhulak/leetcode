package com.strings;
//easy
public class ConsequtiveCharacters {
	
	public int maxPower(String s) {
        
	    int max = 1;
	      
	        int count=1;
	        for(int j=1; j<s.length(); j++){
	            
	            if(s.charAt(j-1) != s.charAt(j)){
	                max= Math.max(count , max);
	                count=1;
	            }
	            else
	            count++;
	           
	            
	        }
	        return Math.max(max, count);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stubs

	}

}
