package com.snc.affirm;

public class SubarrayProductLessThanK {
	
	 public int numSubarrayProductLessThanK(int[] nums, int k) {
	       if(k <= 1)
	           return 0;
	       
	        int pevProduct=1;
	        int count=0;
	        int i=0;
	        
	        for(int j=0 ; j<nums.length; j++){
	            
	            
	            pevProduct*=nums[j];
	            
	             
	            while( pevProduct >= k){
	                
	                pevProduct=pevProduct/nums[i];
	                i++;
	            }
	            
	          count+=j-i+1;
	            
	            
	        }
	        
	        return count;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
