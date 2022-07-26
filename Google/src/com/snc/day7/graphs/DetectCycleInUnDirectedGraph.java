package com.snc.day7.graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInUnDirectedGraph {
	
	
	public static void addEdge(int source , int dest , List<LinkedList<Integer>> adj) {
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}
	
	public static boolean isCyclicUtil(int v , boolean[] visited , int parent , List<LinkedList<Integer>> adj) {
		
		visited[v] = true;
		
		int i;
		
		for(int children : adj.get(v)) {
			i = children;
			if(!visited[i]) {
			if(isCyclicUtil(children , visited , v , adj))
				return true;
			}
			
			else if(i != parent)
				return true;
			
		}
		
		return false;
	}
	
	
	public static boolean isCycle(List<LinkedList<Integer>> adj , int v) {
		
		boolean visited[] = new boolean[v];
		
		
		for(int i=0 ; i<v; i++) {
			
			if(!visited[i])
			if(isCyclicUtil(i , visited , -1 , adj))
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
		int v = 4;
		
		for(int i=0 ; i<v; i++) {
			adj.add(new LinkedList<Integer>());
		}
		
		addEdge(0,1 ,adj); 
        addEdge(1, 2, adj); 
        addEdge(2, 3, adj); 
        addEdge(0, 2, adj); 
       
		
		
		System.out.println(isCycle(adj , 4));
		
	}

}
