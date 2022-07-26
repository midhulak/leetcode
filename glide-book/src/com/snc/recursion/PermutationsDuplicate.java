package com.snc.recursion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsDuplicate {

	public static List<List<Integer>> permsDups(List<Integer> items){
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		for(int item : items) {
			
			if(map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			}
			else
				map.put(item, 1);
				
			}
		
		permsDups( result ,  map , new LinkedList<Integer>() );
		
		return result;
		
		}
		
	public static void permsDups( List<List<Integer>> result , HashMap<Integer , Integer> items , List<Integer> path ) {
		
		
		if(items.isEmpty()) {
			result.add(new LinkedList<Integer>(path));
			return;
		}
		
		for(Integer i : new HashSet<Integer>(items.keySet())) {
			int curr = items.get(i);
			if(curr == 1) {
				items.remove(i);
			}
			else
				items.put(i, curr-1);
			
			path.add(i);
			
			permsDups(result , items , path);
			
			items.put(i ,curr);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> n = new LinkedList<Integer>();
		n.add(1);
		n.add(2);
		n.add(1);
		n.add(3);
		
		System.out.println(permsDups(n));

	}

}
