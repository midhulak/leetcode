package com.snc.facebook.phone;

public class TwoStringsEqual {
	
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
	    StringBuffer sb1 = new StringBuffer();
	         StringBuffer sb2 = new StringBuffer();
	        
	         
	        for(int i=0 ; i<word1.length; i++){
	            sb1.append(word1[i]);
	        }
	        
	          for(int j=0 ; j<word2.length; j++){
	            sb2.append(word2[j]);
	        }
	        
	        if( sb1.toString().equals(sb2.toString()) )
	            return true;
	        
	        
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
