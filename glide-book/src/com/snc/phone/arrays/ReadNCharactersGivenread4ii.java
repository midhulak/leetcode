package com.snc.phone.arrays;

public class ReadNCharactersGivenread4ii {
	
	   /**
	    * // Time complexity: O(N)O(N) to copy N characters.

	// Space complexity: O(1)O(1) to keep buf4 of 4 elements.
	
	//https://leetcode.com/problems/read-n-characters-given-read4/
	 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
	    */
	   private char[] temp = new char[4];
	   private int tempPtr=0;
	   private int tempCount=0;
	    
	    public int read(char[] buf, int n) {
	        int total=0;
	        
	        while(total < n){
	            
	            if(tempPtr == 0)
	            tempCount = read4(temp);
	            
	            while(total < n && tempPtr < tempCount){
	                
	                buf[total++] = temp[tempPtr++];
	               
	            }
	            
	            if(tempCount < 4)
	                break;
	            //if we used all charcaters from read4 we need to rest to 0 so taht it call again next time
	            if(tempCount == tempPtr)
	                tempPtr=0;
	            
	           
	        
	    }
	         return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
