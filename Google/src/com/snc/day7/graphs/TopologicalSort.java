package com.snc.day7.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	
	static Stack<Integer> stack = new Stack<Integer>();
	
	
	public static void addEdge(int u ,int v ,List<ArrayList<Integer>> adj ) {
		
		adj.get(u).add(v);
	}
	
	public static void topologicalSort(int v , List<ArrayList<Integer>> adj) {
		
		boolean[] visited = new boolean[v];
		
		for(int i=0 ; i<v ; i++) {
			if(!visited[i]) {
				
				dfsUtil(i , visited , adj );
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
	
	public static void dfsUtil(int v , boolean[] visited , List<ArrayList<Integer>> adj) {
		
		visited[v] = true;
		
		for(int child : adj.get(v)) {
			
			if(!visited[child])
				dfsUtil(child , visited , adj);
				
		}
		
		stack.push(v);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0 ; i<6; i++) {
			adj.add(new ArrayList<Integer>());
		}
//		addEdge(5,2,adj);
//		addEdge(5,0,adj);
//		addEdge(4,0,adj);
//		addEdge(2,3,adj);
//		addEdge(3,1,adj);
//		addEdge(4,1,adj);
		
		addEdge(4,1,adj);
		addEdge(4,0,adj);
		addEdge(5,0,adj);
		addEdge(5,2,adj);
		addEdge(2,3,adj);
		addEdge(3,1,adj);
		
		topologicalSort(6,adj);
		
		
//List<ArrayList<Integer>> adj1= new ArrayList<ArrayList<Integer>>();
//		
//		for(int i=1 ; i<=3; i++) {
//			adj1.add(new ArrayList<Integer>());
//		}
//		addEdge(5,2,adj);
//		addEdge(5,0,adj);
//		addEdge(4,0,adj);
//		addEdge(2,3,adj);
//		addEdge(3,1,adj);
//		addEdge(4,1,adj);
		
//		addEdge(1,2,adj1);
//		addEdge(2,3,adj1);
//		addEdge(3,1,adj1);
//		addEdge(5,2,adj);
//		addEdge(2,3,adj);
//		addEdge(3,1,adj);
		
	//	topologicalSort(3,adj1);
		
	}

}
