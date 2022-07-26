package com.snc.onsite.set1;

public class isSubsequence {
	
	 public boolean isSubsequence(String s, String t) {
	        
	        if(s.length() == 0)
	            return true;
	        
	        int j=0;
	        
	        for(int i=0; i<t.length(); i++){
	            
	            
	            if(s.charAt(j) == t.charAt(i))
	                j++;
	            
	            if(j>=s.length())
	                return true;
	            
	        }
	        
	        return false;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
