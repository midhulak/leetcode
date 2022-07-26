package com.snc.day7.graphs;

import java.util.ArrayList;

public class TransitiveClosure {

public static void addEdge(int u , int v , ArrayList<ArrayList<Integer>> adj) {
		
		adj.get(u).add(v);
	}
	
	
	public static void  TransitiveClosure(ArrayList<ArrayList<Integer>> adj , int v) {
		
		
		boolean[] visited = new boolean[v];
		for(int i=0 ; i<v; i++) {
			
			if(!visited[i]) {
				boolean[] getVisited= DFSUtil(visited , i , adj);
				
			String s =	checkAllVisitedforNode(getVisited);
			System.out.println(s);
			visited = new boolean[v];
			
			
		}
		
		
		
	}
		
	}
	
	public static String checkAllVisitedforNode(boolean[] visited) {
		StringBuffer sb = new StringBuffer();
		for(boolean node : visited) {
			if(node)
				sb.append("1"+" ");
			else
				sb.append("0"+" ");
		}
		
		return sb.toString();
		
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
		int v=4;
		int e=8;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0 ; i<v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(0,1,adj);
		addEdge(0,2,adj);
		addEdge(1,2,adj);
		addEdge(2,0,adj);
		addEdge(2,3,adj);
		addEdge(3,3,adj);
		
		
		//dfs(5,7,adj);
		
  TransitiveClosure(adj , 4);
		
	}

}
