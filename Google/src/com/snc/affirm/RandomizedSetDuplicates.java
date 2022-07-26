package com.snc.affirm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSetDuplicates {
	
	ArrayList<Integer> list;
	Map<Integer , Set<Integer>> map;
	
	Random rand ;
	
	
	RandomizedSetDuplicates(){
		
		list = new ArrayList<Integer>();
		map = new HashMap<>();
		rand = new Random();
	}
	
	
	
	public boolean insert(int val) {
		
		if(!map.containsKey(val)) {
			map.put(val, new LinkedHashSet<Integer>());
			
		}
		
		map.get(val).add(list.size());
		list.add(list.size(), val);
			
		
		return map.get(val).size() == 1;
	}

	
	
	public boolean remove(int val) {
		
		if(!map.containsKey(val) || map.get(val).size() == 0)
			return false;
		
		int removeIdx = map.get(val).iterator().next();
		map.get(val).remove(removeIdx);
		
		
		int lastElement = list.get(list.size() - 1);
		map.get(lastElement).add(removeIdx);
		map.remove(lastElement).remove(list.size()-1);
		
		list.set(removeIdx , lastElement);
		list.remove(list.size() - 1);
		
		return true;
		
	}
	
	
	
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
