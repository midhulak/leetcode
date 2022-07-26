package com.snc.day7.graphs;

import java.util.ArrayList;

public class MotherVertex {
	
	
	public static void addEdge(int u , int v , ArrayList<ArrayList<Integer>> adj) {
		
		adj.get(u).add(v);
	}
	
	
	public static int  motherVertex(ArrayList<ArrayList<Integer>> adj , int v) {
		
		
		boolean[] visited = new boolean[v];
		for(int i=0 ; i<v; i++) {
			
			if(!visited[i]) {
				boolean[] getVisited= DFSUtil(visited , i , adj);
				
			boolean check =	checkAllVisitedforNode(getVisited);
			
			
			if(check)
				return i;
			else
				visited = new boolean[v];
		}
		
		
		
	}
		return -1;
	}
	
	public static boolean checkAllVisitedforNode(boolean[] visited) {
		
		for(boolean node : visited) {
			if(!node)
				return false;
		}
		
		return true;
		
	}
	
	public static boolean[] DFSUtil(boolean[] visited , int v , ArrayList<ArrayList<Integer>> adj ) {
		
		visited[v] = true;
		//System.out.println("vertex visited is v="+v);
		
		for(int x: adj.get(v)) {
		
			if(!visited[x]) {
				DFSUtil(visited , x , adj);
			}
		}
		
		return visited;
		
	}
	
	public static void dfs(int v , int vertices , ArrayList<ArrayList<Integer>> adj) {
		
		boolean[] visited = new boolean[vertices];
		DFSUtil(visited , v , adj);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=7;
		int e=8;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0 ; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(0,1,adj);
		addEdge(0,2,adj);
		addEdge(1,3,adj);
		addEdge(4,1,adj);
		addEdge(6,4,adj);
		addEdge(5,6,adj);
		addEdge(5,2,adj);
		addEdge(6,0,adj);
		
		//dfs(5,7,adj);
		
      System.out.println(motherVertex(adj , v));
		
	}

}
