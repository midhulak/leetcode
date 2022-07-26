package com.snc.recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	//https://leetcode.com/explore/interview/card/facebook/53/recursion-3/292/
	
	  /**
    //Tc:
//	BF:O(n)
//	Height :O(n)
//	Work per recursive call
//	 copy path or copy/iterate over items
//O(n! * n)
//SC:
//
**/
    public List<List<Integer>> permute(int[] nums) {
        
        
        	Set<Integer> items = new HashSet<>();
      for(int n : nums){
          items.add(n);
      }
		
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		
		perms(new  LinkedList<Integer>() ,items , results);
		
		return results;
	}
	
	
	public static void perms( List<Integer> path , Set<Integer> items , List<List<Integer>> results ) {
		
		if(items.isEmpty()) {
			
			results.add(new LinkedList<Integer>(path));
			return;
		}
		
		
		for(Integer i: items.toArray(new Integer[]{})){
			
			items.remove(i);
			path.add(i);
			perms( path , items , results );
			items.add(i);
		
			path.remove(path.size() - 1);
			
			
		}
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
