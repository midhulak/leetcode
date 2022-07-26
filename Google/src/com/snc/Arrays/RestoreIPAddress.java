package com.snc.Arrays;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	 public List<String> restoreIpAddresses(String s) {
	        
	        List<String> res = new ArrayList<>();
	        
	        if(s.length() > 12)
	            return res;
	        
	        int n = s.length();
	        
	        for(int i=1 ; i<n && i<4; ++i){
	            
	            String first = s.substring(0,i);
	            if(!isValid(first))
	                continue;
	            
	            for(int j=1; i+j<n && j <4 ; ++j){
	                String second = s.substring(i , i+j);
	                
	                if(!isValid(second))
	                    continue;
	                
	                for(int k=1; i+j+k<n && k <4 ; ++k){
	                    String third = s.substring(i+j , i+j+k);
	                    String fourth = s.substring(i+j+k);
	                    
	                    if(!isValid(third) || !isValid(fourth))
	                        continue;
	                    
	                    res.add(first+"."+second+"."+third+"."+fourth);
	                    
	                }
	            }
	        }
	        
	        
	        return res;
	        
	    }
	    
	    public boolean isValid(String s){
	        
	        if(s.length() > 3)
	            return false;
	        
	        if(s.startsWith("0") && s.length() >1)
	            return false;
	        
	        int val = Integer.parseInt(s);
	        
	        return val >=0 && val <= 255;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
