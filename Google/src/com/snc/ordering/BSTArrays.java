package com.snc.ordering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class BSTArrays {
	
	 static class  Node{
			Node left;
			Node right;
			int val;
			Node(){
				
			}
		}
	
	public static List<List<Integer>> allBSTOrders(Node root){
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		allBSTOrders(new HashSet<Node>(Arrays.asList(root)) , results);
		return null;
		
	}
	
	public static void allBSTOrders(Set<Node> available , List<Integer> path , List<List<Integer>> results) {
		
		
		if(available.isEmpty()) {
			results.add(new ArrayList<Integer>(path));
			return;
		}
		
		for(Node n : available.toArray(new Node[]{})) {
			
			available.remove(n);
			if(n.left != null)
				available.add(n.left);
			if(n.right != null)
				available.add(n.right);
			
			path.add(n.val);
			
			allBSTOrders(available , path , results);
			
			path.remove(path.size()-1);
			
			if(n.left != null)
				available.remove(n.left);
			
			if(n.right != null)
				available.remove(n.right);
			
			available.add(n);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
