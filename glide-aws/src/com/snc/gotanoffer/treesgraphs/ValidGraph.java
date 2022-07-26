package com.snc.gotanoffer.treesgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidGraph {
	
	  
	   /*
	   Time complexity : in both serialization and deserialization functions, we visit each node exactly once, thus the time complexity is O(N)O(N), where NN is the number of nodes, i.e. the size of tree.

	Space complexity : in both serialization and deserialization functions, we keep the entire tree, either at the beginning or at the end, therefore, the space complexity is O(N)O(N).
	*/
			
	    
	    private List<List<Integer>> adjacencyList = new ArrayList<>();
	    private Set<Integer> seen = new HashSet<>();
	    
	    
	    public boolean validTree(int n, int[][] edges) {
	        
	        if (edges.length != n - 1) return false;
	        
	        for (int i = 0; i < n; i++) {
	            adjacencyList.add(new ArrayList<>());
	        }
	        for (int[] edge : edges) { //adding into lists for eg; 0,1 at 0 add 1 and at 1 add 0
	            adjacencyList.get(edge[0]).add(edge[1]);
	            adjacencyList.get(edge[1]).add(edge[0]);
	        }
	        
	        // We return true iff no cycles were detected,
	        // AND the entire graph has been reached.
	        return dfs(0, -1) && seen.size() == n;   //initially starting with 0 an dparent is -1
	    }
	    
	    public boolean dfs(int node, int parent) {
	        if (seen.contains(node)) return false;
	        seen.add(node);
	        for (int neighbour : adjacencyList.get(node)) {
	            if (parent != neighbour) {
	                boolean result = dfs(neighbour, node);
	                if (!result) return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
