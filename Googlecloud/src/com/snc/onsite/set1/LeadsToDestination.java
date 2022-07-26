package com.snc.onsite.set1;

import java.util.LinkedList;
import java.util.List;

public class LeadsToDestination {
	
	 public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
	        
		    if(edges.length == 0 && source == destination)
		        return true;
		        
		        if(edges.length == 0 && source != destination)
		         return false;
		        
		        List<Integer>[] graph = new List[n];
		        int[] colors = new int[n];
		        buildGraph(graph , edges);
		        
		        return dfs(graph , source , destination , colors);
		    
		}
		    
		    public boolean dfs(List<Integer>[] graph , int source , int destination, int[] colors){
		        if(graph[source] == null || graph[source].size() == 0)
		            return source == destination;
		        
		        colors[source] = 1;
		        for(int next : graph[source]){
		            if(colors[next] == 1)
		                return false;
		            
		            if((colors[next] == 0) && !dfs(graph , next , destination , colors))
		                return false;
		            
		            
		        }
		        
		       colors[source] = 2;
		        return true;
		    } 
		    
		    private void buildGraph(List<Integer>[] graph , int[][] edges){
		        
		        for(int[] e : edges){
		            int from = e[0];
		            int to = e[1];
		            
		            if(graph[from] == null)
		                graph[from] = new LinkedList<>();
		            
		            graph[from].add(to);
		        }
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
