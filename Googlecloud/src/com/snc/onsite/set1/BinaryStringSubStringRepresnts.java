package com.snc.onsite.set1;

public class BinaryStringSubStringRepresnts {
	
	  public boolean queryString(String s, int n) {
	        
	        for(int i=1; i<=n ; i++){
	            if(s.indexOf(Integer.toBinaryString(i))== -1)
	                return false;
	                
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	BinaryStringSubStringRepresnts b = new BinaryStringSubStringRepresnts();
	System.out.println(b.queryString("0110", 3));
	}

}
