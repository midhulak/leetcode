package com.snc.square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BusRoutes {
	
	
	public static  int numBusesToDest(int[][] routes , int source , int target) {
		
		Map<Integer, Set<Integer>> map = new HashMap<Integer , Set<Integer>>();
		
		int minVal = Integer.MAX_VALUE;
		
		for(int i=0 ; i<routes.length; i++) {
			
		
			for(int j=0 ; j< routes[i].length-1; j++) {
				
				
				if(map.containsKey(routes[i][j])) {
					Set<Integer> set1 = map.get(routes[i][j]);
					set1.add(routes[i][j+1]);
				  map.put(routes[i][j], set1);
				}
				else {
					Set<Integer> set1 = new HashSet<Integer>();
					set1.add(routes[i][j+1]);
					Set<Integer> set2 = new HashSet<Integer>();
					set2.add(routes[i][j]);
					map.put(routes[i][j], set1);
					map.put(routes[i][j+1], set2);
				}
			}
			
			Set<Integer> set = new HashSet<Integer>();
			set.add(routes[i][0]);
			
			map.put(routes[i][routes[i].length-1], set);
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] routes = { {1,2,7} ,  {3,6,7} };
		
		numBusesToDest(routes , 1 ,6);
		
		
	}

}
