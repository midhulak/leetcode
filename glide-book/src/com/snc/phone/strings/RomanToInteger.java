package com.snc.phone.strings;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/roman-to-integer/solution/ */


/*
 * 
 * Let nn be the length of the input string (the total number of symbols in it).

Time complexity : O(1)O(1).

As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX. As such the time complexity is O(1)O(1).

If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the length of the input, i.e. O(n)O(n). This is assuming that looking up the value of each symbol is O(1)O(1).

Space complexity : O(1)O(1).

Because only a constant number of single-value variables are used, the space complexity is O(1)O(1).


 */
public class RomanToInteger {
	
	public int romanToInt(String s) {
	    
        Map<String , Integer> values = new HashMap<>();
        
        values.put("M" , 1000);
        values.put("D" , 500);
        values.put("C" , 100);
        values.put("L" , 50);
        values.put("X" , 10);
        values.put("V" , 5);
        values.put("I" , 1);
            
     String lastSymbol = s.substring(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int total = lastValue;
        
        
        for(int i=s.length()-2 ; i >= 0 ; i--){
            
            String currentSymbol = s.substring(i,i+1);
            int currentValue = values.get(currentSymbol);
            
            if(currentValue < lastValue)
                total-= currentValue;
            
            else
                total+=currentValue;
            
            lastValue = currentValue;
        }
         return total;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
