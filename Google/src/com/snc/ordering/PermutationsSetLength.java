package com.snc.ordering;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsSetLength {
	
	public static List<List<Integer>> permutationsOfSetLength(Set<Integer> items , int length){
		if(length > items.size())
			return null;
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		permutationsOfSetLength(items , length , new LinkedList<Integer>() , results);
		return results;
		
	}
	
	private static void permutationsOfSetLength(Set<Integer> items , int length , List<Integer> path , 
			List<List<Integer>> results) {
		
		if(length == 0) {
			results.add(new LinkedList<Integer>(path));
			return;
			
		}
		
		for(Integer i : items.toArray(new Integer[] {})) {
			items.remove(i);
			path.add(i);
			permutationsOfSetLength(items , length-1 , path , results);
			items.add(i);
			path.remove(path.size() - 1);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
