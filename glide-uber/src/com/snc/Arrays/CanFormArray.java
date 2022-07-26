package com.snc.Arrays;

import java.util.HashMap;

import java.util.Map;


/**
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order.
 *  However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

 

Example 1:

Input: arr = [15,88], pieces = [[88],[15]]
Output: true
Explanation: Concatenate [15] then [88]
Example 2:

Input: arr = [49,18,16], pieces = [[16,18,49]]
Output: false
Explanation: Even though the numbers match, we cannot reorder pieces[0].
Example 3:

Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
Output: true
Explanation: Concatenate [91] then [4,64] then [78]

https://leetcode.com/problems/check-array-formation-through-concatenation/
 
 * @author midhula.kadiyala
 *
 */

public class CanFormArray {
	
	 public boolean canFormArray(int[] arr, int[][] pieces) {
	        Map<Integer, int[]> _map = new HashMap<>();
	        //  //adding first piece and piece array into map
	        for(int[] p: pieces)
	            _map.put(p[0], p);
	        
	        int idx = 0;
	        while(idx < arr.length){
	        	//   //then check every index in array is key in map and map pieces are next elements of an array or not?
	            if(_map.containsKey(arr[idx])){
	                int[] piece = _map.get(arr[idx]);
	                for(int p: piece){
	                    if(p != arr[idx]) return false;
	                    else idx++;
	                }
	            } else 
	                return false;
	        }
	        return true;
	    }

}
