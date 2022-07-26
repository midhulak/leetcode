package com.snc.ordering;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsUsingRemoval {
	
	public static List<List<Integer>> permutations(Set<Integer> items){
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		permutations(items , new LinkedList<Integer>() , results);
		return results;
	}
	
	private static void permutations(Set<Integer> items , List<Integer> path ,
   List<List<Integer>> results) {
		if(items.isEmpty()) {
			results.add(new LinkedList<Integer>(path));
			return;
		}
		for(Integer i : items.toArray(new Integer[]{})) {
			items.remove(i);
			path.add(i);
			permutations(items, path , results);
			items.add(i);
			path.remove(path.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		
		System.out.println(permutations(list));
	}

}
