package com.snc.arrays;

public class ConsequtiveNumberSum {
	
	public int consecutiveNumbersSum(int num) {
	    int i=1; int count=0;
	        
	        while(num > 0){
	            num-=i;
	            if(num %i == 0)
	                count++;
	            i++;
	        }
	      return count;
	    }
	

	/*15
	4+5+6
	    (3+1) +(3+2) +(3+3) = 15
	    3+3+3-15-1-2-3
	    
	    15
	    (14 + 1)
	    
	    (15 - 1 -2 -3 -4 -5)%5 == 0
	    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
