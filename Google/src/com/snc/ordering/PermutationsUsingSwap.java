package com.snc.ordering;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsUsingSwap {
	
	public static List<List<Integer>> permutations(int[] items){
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		permutations(items , 0 , new LinkedList<Integer>() , results);
		return results;
		
	}
	
	public static void permutations(int[] items , int i , List<Integer> path,
			List<List<Integer>> results) {
		
		if(i == items.length) {
			results.add(new LinkedList<Integer>(path));
			return;
		}
		
		for(int j=i; j< items.length; j++) {
			swap(items , i , j);
			path.add(items[i]);
			permutations(items , i+1 , path , results);
			swap(items , i , j);
			path.remove(path.size() - 1);
			
		}
		
	}

	
	private static void swap(int[] items , int i , int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,2,3};
		
		
		System.out.println(permutations(a));

	}

}
