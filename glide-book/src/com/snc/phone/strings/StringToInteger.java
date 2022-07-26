package com.snc.phone.strings;

public class StringToInteger {

	
	 public int myAtoi(String s) {
	        
	        double result= 0;
	        s = s.trim();
	        
	        if(s.length() == 0 || s == null)
	            return 0;
	        
	        boolean isNegative = false;
	        int index=0;
	        //if negative we need to add - at the end so captured in boolean variable
	        if(s.charAt(0) == '-' || s.charAt(0) == '+')
	            index++;
	        
	        
	        if(s.charAt(0) == '-'){
	            isNegative = true;
	            
	        }
	        
	        //need to check each character in the string is a valid integer or not
	        for(int i=index; i<s.length(); i++){
	            //if it is not between 0 and 9 just break the loop
	            if(s.charAt(i) < '0' || s.charAt(i) > '9')
	                break;
	            int digitVal = (int)(s.charAt(i) - '0'); //just multiply by result so that we can just add the next digit to taht
	            result = result*10+digitVal;
	        }
	        
	        if(isNegative)
	            result = -result;
	        
	        if(result > Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	        
	        if(result < Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	        
	        return (int)result;
	        
	    }
}
