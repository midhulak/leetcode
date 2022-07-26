package com.snc.Trees.graphs;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
	
	  
    private final char[][] mapping = {{'0' , '0'} , {'1' ,'1'} , {'6'
,'9'} , {'8' , '8'} , {'9' , '6'} };	
public List<String> findStrobogrammatic(int n){
	List<String>  res = new ArrayList<>();
	
	if(n < 1)
		return res;
	char[] chs = new char[n];
	
	helper(chs , 0 , n-1 , res);
	
	return res;
}
//applying binary search and trying to add same numbers to the left and right from pairs where 0th index and ist index are same
//and try to apply this logic recursively\\//try to add same numbers in map left and right recursively and fill the numbers in between

private void helper(char[] chs , int lo , int hi , List<String> res) {
	if(lo > hi) {
		if(chs.length == 1 || chs[0] != '0') {
			res.add(String.valueOf(chs));
		}
		return;
	}
	 
	for(char[] map : mapping) {
		if(lo == hi && map[0] != map[1])
			continue;
		
		chs[lo] = map[0];
		chs[hi] = map[1];
		helper(chs , lo+1 , hi-1 , res);
		
	}
	
    
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
