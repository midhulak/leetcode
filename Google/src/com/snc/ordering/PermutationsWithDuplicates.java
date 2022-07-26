package com.snc.ordering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationsWithDuplicates {
	
	public static List<List<Integer>> permutations(List<Integer> items){
		
		List<List<Integer>> results = new LinkedList<>();
		HashMap<Integer , Integer> itemCounts = new HashMap<>();
		
		for(int i : items) {
			
			if(itemCounts.containsKey(i)) {
				itemCounts.put(i , itemCounts.get(i)+1);
			}
			else {
				itemCounts.put(i, 1);
			}
		}
		
		permutations(itemCounts , new LinkedList<Integer>(), results);
		
		return results;
		
		
	}
	
	public static void permutations(Map<Integer , Integer> itemCounts , List<Integer> path , 
			List<List<Integer>> results) {
		
		if(itemCounts.isEmpty()) {
			results.add(new LinkedList<Integer>(path));
			System.out.println(results);
			return;
		}
		
		for(Integer i : new HashSet<Integer>(itemCounts.keySet())) {
			System.out.println("item value is="+i);
			 int curr = itemCounts.get(i);
			 if(curr == 1)
				 itemCounts.remove(i);
			 else
				 itemCounts.put(i,  curr-1);
			 
			 path.add(i);
			 permutations(itemCounts , path , results);
			 System.out.println("after item value is="+i);
			 itemCounts.put(i,  curr);
			 path.remove(path.size()-1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		
		
		System.out.println(permutations(list));

	}

}
