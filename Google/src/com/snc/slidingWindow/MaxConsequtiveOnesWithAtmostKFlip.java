package com.snc.slidingWindow;

public class MaxConsequtiveOnesWithAtmostKFlip {
	//1 0 1 1 0
	public static int printMax(int[] nums) {
		
		 int max=0;
	       int k=1;
	        int j=0;
	        
	        for(int i=0; i< nums.length; i++){
	            
	            if(nums[i] == 0)
	                k--;
	            
	            while(k < 0){
	                
	                if(nums[j] == 0)
	                    k++;
	                
	                j++;
	            }
	            
	           max=Math.max(max , i-j+1);
	           
	        }
	        return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {1,0,1,1,0};
		System.out.println(printMax(nums));

	}

}
