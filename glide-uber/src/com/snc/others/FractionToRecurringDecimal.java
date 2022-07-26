package com.snc.others;

import java.util.HashMap;

import java.util.Map;

/** https://leetcode.com/problems/fraction-to-recurring-decimal/ **/


	
public class FractionToRecurringDecimal {
	/*
	 * Space Complexity: O(|denominator|). In the while loop value of remainder is always [0,denominator-1] due to modulus operator.

Time Complexity: O(log(|numerator|)/log(|denominator|))?
	 */
	 public String fractionToDecimal(int numerator, int denominator) {
	        
	        if(numerator == 0 )
	            return "0";
	        
	        StringBuilder sb = new StringBuilder();
	        /*if either 1 value is minus then our result contains - */
	        if(numerator < 0 && denominator >0 || numerator > 0 && denominator < 0){
	            sb.append("-");
	        }
	        
	        /* trying to do division */
	        long divisor = Math.abs((long)numerator);
	        long dividend = Math.abs((long)denominator);
	        /* try to do mod and if reminder is 0 then it is perfect division */
		       
	        long remainder = divisor % dividend;

	        sb.append(divisor/dividend);
	        
	        //if remainder is 0 it is perfect division no need to go recursion
	        if(remainder == 0)
	            return sb.toString();
	    
	    //otherwise add .
	    sb.append(".");
	    
	    Map<Long, Integer> map = new HashMap<>();
	       //if reminder not zero we add dot to the quotent and mutltipl the reminder by 10
	        while(remainder != 0){
	            /* if we get same reminder again and again then add brackets to it */
	            if(map.containsKey(remainder)){
	                
	                sb.insert(map.get(remainder) , "(");
	                sb.append(")");
	                break;
	            }
	           
	            map.put(remainder , sb.length());
	            //then multiply reminder with 10 
	            remainder*=10;
	            sb.append(remainder/dividend);
	            remainder%=dividend;
	            
	        }
	        return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
