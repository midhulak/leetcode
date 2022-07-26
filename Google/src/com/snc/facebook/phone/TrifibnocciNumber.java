package com.snc.facebook.phone;

public class TrifibnocciNumber {
	
	 public int tribonacci(int n) {
	        
	        if(n < 2)
	            return n;
	        if(n == 2)
	            return 1;
	        int firstNum=0;
	        int secondNum =1;
	        int thirdNum=1;
	        int result=0;
	        n=n-2;
	        
	        while(n > 0){
	            
	            result = firstNum+secondNum+thirdNum;
	            
	            firstNum=secondNum;
	            secondNum=thirdNum;
	            thirdNum=result;
	            n--;
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
