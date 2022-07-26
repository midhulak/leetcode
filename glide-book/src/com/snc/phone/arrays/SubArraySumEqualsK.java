package com.snc.phone.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	
	/*
	 * https://leetcode.com/problems/subarray-sum-equals-k/
    Time complexity : O(n)O(n). The entire numsnums array is traversed only once.

Space complexity : O(n)O(n). Hashmap mapmap can contain up to nn distinct entries in the worst case.


*/
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

	}

}
