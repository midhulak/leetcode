package com.snc.day7.graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInDirectedGraph {
	
	
	public static void addEdge(int source , int dest , List<LinkedList<Integer>> adj) {
		adj.get(source).add(dest);
	}
	
	public static boolean isCyclicUtil(int i , boolean[] visited , boolean[] recStack, List<LinkedList<Integer>> adj) {
		
		
		if(recStack[i])
			return true;
		if(visited[i])
			return false;
		
		visited[i] = true;
		recStack[i] = true;
		
		for(int children : adj.get(i)) {
			
			if(  isCyclicUtil(children , visited , recStack , adj))
				return true;
			
			
		}
		
		recStack[i] = false;
		
		return false;
	}
	
	
	public static boolean isCycle(List<LinkedList<Integer>> adj , int v) {
		
		boolean visited[] = new boolean[v];
		boolean restack[] = new boolean[v];
		for(int i=0 ; i<v; i++) {
			
			
			if(isCyclicUtil(i , visited , restack , adj))
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
		int v = 6;
		
		for(int i=0 ; i<v; i++) {
			adj.add(new LinkedList<Integer>());
		}
		
		addEdge(0,1 ,adj);
		addEdge(0,2 ,adj);
		addEdge(1,2 ,adj);
		//addEdge(2,0 ,adj);
		addEdge(2,3 ,adj);
		//addEdge(3,3 ,adj);
		
//		addEdge(5,2,adj);
//		addEdge(5,0,adj);
//		addEdge(5,3,adj);
//		addEdge(5,4,adj);
//		addEdge(5,1,adj);
//		addEdge(4,1,adj);
//		addEdge(4,0,adj);
//		addEdge(4,2,adj);
//		addEdge(4,3,adj);
//		addEdge(2,3,adj);
//		addEdge(2,1,adj);
//		addEdge(2,0,adj);
//		addEdge(1,0,adj);
		
		
		System.out.println(isCycle(adj , 4));
		
	}

}
