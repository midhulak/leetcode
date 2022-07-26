package com.strings;

public class AToI {

public int myAtoi(String s) {
        
        double result=0;
        s = s.trim();
        if(s.length() == 0 || s == null)
            return 0;
        boolean isNegative=false;
        int index=0;
        
        if(s.charAt(0) == '-' || s.charAt(0) == '+')
            index++;
        
        if(s.charAt(0) == '-')
            isNegative = true;
        
        for(int i=index; i<s.length(); i++){
            
            
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                break;
            
            int digitVal = (int)(s.charAt(i) - '0');
            
            result = result *10 +digitVal;
            
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
