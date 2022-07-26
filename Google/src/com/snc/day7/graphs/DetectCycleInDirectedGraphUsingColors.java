package com.snc.day7.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInDirectedGraphUsingColors {
	
	
	public static void addEdge(int source , int dest , List<LinkedList<Integer>> adj) {
		adj.get(source).add(dest);
	}
	
	
	public static boolean dfsUtil(int v , String[] color , List<LinkedList<Integer>> adj) {
		
	  color[v] = "Grey";
	  
	  for(int child : adj.get(v)) {
		  if(color[child] == "Grey")
			  return true;
		  
		  if(color[child] == "white" && dfsUtil(child , color , adj ))
			  return true;
		  
	  }
		
		color[v] = "black";
		
		return false;
	}
	
	public static boolean isCycle(List<LinkedList<Integer>> adj , int v) {
		
		String[] color = new String[v];
		
		for(int i=0 ; i<v; i++) {
			color[i]="white";
		}
		
		for(int i=0 ; i<v; i++) {
			
			if(color[i] == "white") {
				if(dfsUtil(i , color , adj))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		List<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
		int v = 3;
		
		for(int i=0 ; i<=v; i++) {
			adj.add(new LinkedList<Integer>());
		}
		
//		addEdge(0,1 ,adj);
//		addEdge(0,2 ,adj);
//		addEdge(1,2 ,adj);
//		addEdge(2,0 ,adj);
//		addEdge(2,3 ,adj);
//		addEdge(3,3 ,adj);
		
		addEdge(1,2,adj);
		addEdge(2,3,adj);
		addEdge(3,1,adj);
		
		
		System.out.println(isCycle(adj , 4));

	}

}
