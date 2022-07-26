package com.snc.day7.graphs;

import java.util.ArrayList;
import java.util.List;

public class MinimumSemesters {
	
	 public static int minimumSemesters(int N, int[][] relations) {
	        
	        int[] visited = new int[N+1];
	        int[] reVisit = new int[N+1];
	        
	     //  [[1,3],[2,3]] 
	        // 3 -> 1,2
	        //
	        
	         List<List<Integer>> graph = new ArrayList<>(N + 1);
	        for (int i = 0; i < N + 1; ++i) {
	            graph.add(new ArrayList<Integer>());
	        }
	        for (int[] relation : relations) {
	            graph.get(relation[0]).add(relation[1]);
	        }
	        
	       int maxLength = 1;
	        for (int node = 1; node < N + 1; node++) {
	            int length = dfs(node, graph, visited);
	            // we meet a cycle!
	            if (length == -1) {
	                return -1;
	            }
	            maxLength = Math.max(length, maxLength);
	        }
	        return maxLength;
	      
	        
	    }
	    
	   
	    
	  private static int dfs(int node, List<List<Integer>> graph, int[] visited) {
	        // return the longest path (inclusive)
	        if (visited[node] != 0) {
	            return visited[node];
	        } else {
	            // mark as visiting
	            visited[node] = -1;
	        }
	        int maxLength = 1;
	        for (int endNode : graph.get(node)) {
	            int length = dfs(endNode, graph, visited);
	            // we meet a cycle!
	            if (length == -1) {
	                return -1;
	            }
	            maxLength = Math.max(length + 1, maxLength);
	        }
	        // mark as visited
	        visited[node] = maxLength;
	        return maxLength;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=3;
		int[][] relations = { {1,3} , {2,3} };
		minimumSemesters(n , relations);

	}

}
