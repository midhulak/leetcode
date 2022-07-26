package com.snc.facebook.phone;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	 public int subarraySum(int[] nums, int k) {
	        
	        Map<Integer , Integer> map = new HashMap<>();
	        
	        map.put(0,1);
	        
	        int sum=0;
	        int count=0;
	        
	        for(int i=0 ; i<nums.length; i++){
	            
	            
	            
	            sum+=nums[i];
	            
	            if(map.containsKey(sum-k)){
	                count+=map.get(sum-k);
	                
	            }
	            
	            if(map.containsKey(sum)){
	                map.put(sum , map.get(sum)+1);
	                
	            }
	            else{
	                map.put(sum , 1);
	            }
	        }
	        
	       return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] num= {1,5,6,7,8,9,10};
SubArraySumEqualsK sum = new SubArraySumEqualsK();
   System.out.println(sum.subarraySum(num, 24));

	}

}
