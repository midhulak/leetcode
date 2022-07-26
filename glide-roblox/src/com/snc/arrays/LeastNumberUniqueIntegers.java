package com.snc.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/ */
/*
 * 
 * 1481. Least Number of Unique Integers after K Removals
Medium

868

64

Add to List

Share
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 
 */
public class LeastNumberUniqueIntegers {
	
	 public int findLeastNumOfUniqueInts(int[] arr, int k) {
	        
	        Map<Integer , Integer> map = new HashMap<>();
	        //first put all occurences in a map
	        for(int i=0; i<arr.length; i++){
	            map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
	           
	        }
	        int[] sortMapVal = new int[map.size()];
	        
	        int ite=0;
	     
	        //and try to sort all values from map
	        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	            
	          sortMapVal[ite] = entry.getValue();
	            ite++;
	        }
	        
	        Arrays.sort(sortMapVal);
	        
	        int count=0;
	        int index=0;
	        
	        while(k > 0){
	            int c = sortMapVal[index];
	                //first trying to remove individual chars and incrementing count 
	                if(k >= c)
	                    count++;
	            //if k is going to -ve that means there are still some characters left 
	            k-=c;
	            index++;
	        }
	        //finally we can remve count from mapsize
	        
	        return map.size()-count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
