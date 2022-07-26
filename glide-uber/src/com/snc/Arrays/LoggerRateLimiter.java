package com.snc.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	
	  Map<String , Integer> map;
	    public LoggerRateLimiter() {
	        map = new HashMap<>();
	    }
	    /**
	       /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        
	        if(map.containsKey(message)){
	             
	            if( (timestamp - map.get(message)) >= 10){
	             map.put(message , timestamp);
	                return true;
	            }
	            
	               return false; 
	            
	            
	        }
	        
	        else{
	            
	            map.put(message , timestamp);
	            return true;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
