package com.snc.recursions;

import java.util.LinkedList;
import java.util.List;

//Time complexity: \mathcal{O}(N \times 2^N)O(N×2 
//N
// ) to generate all subsets and then copy them into output list.
//
//Space complexity: \mathcal{O}(N \times 2^N)O(N×2 
//N
// ). This is exactly the number of solutions for subsets multiplied by the number NN of elements to keep for each subset.

/* https://leetcode.com/problems/subsets/solution/ */

public class Subsets {
	
public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        List<Integer> path = new LinkedList<Integer>();
        subsets(result , nums , path , 0 );
        return result;
        
    }
    
    public void subsets( List<List<Integer>> result , int[] nums , List<Integer> path , int index){
        
        
        if(index == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        
        List<Integer> pwc = new LinkedList<>(path);
        
        pwc.add(nums[index]);
        subsets(result , nums , path , index+1);
        subsets(result , nums , pwc , index+1);
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
