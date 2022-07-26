package com.snc.trees.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinSemesters {
	/**
	 * Let EE be the length of relations. NN is the number of courses, as explained in the problem description.

Time Complexity: \mathcal{O}(N+E)O(N+E). For building the graph, we spend \mathcal{O}(N)O(N) to initialize the graph, and spend \mathcal{O}(E)O(E) to add egdes since we iterate relations once. For BFS, we spend \mathcal{O}(N+E)O(N+E) since we need to visit every node and edge once in BFS in the worst case.

Space Complexity: \mathcal{O}(N+E)O(N+E). For the graph, we spend \mathcal{O}(N+E)O(N+E) since we have \mathcal{O}(N)O(N) keys and \mathcal{O}(E)O(E) values. For BFS, we spend \mathcal{O}(N)O(N) since in the worst case, we need to add all nodes to the queue in the same time.
	 * @param n
	 * @param relations
	 * @return
	 */
	
	 public int minimumSemesters(int n, int[][] relations) {
	        List<Integer> adj[] = new ArrayList[n+1];
	        for(int i=0; i<=n; i++ ){
	              adj[i]   = new ArrayList<Integer>();
	        }
	    
	        
	        int[] indegree = new int[n+1];
	        for(int[] relation : relations){
	            adj[relation[0]].add(relation[1]); 
	        }
	        
	        
	        for(int i=1; i<=n; i++ ){
	            
	            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
	            
	            for(int node : temp){
	                indegree[node]++;
	            }
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	     
	        //checking if any course we can take with out any prereqstite
	        for(int i=1; i<=n; i++){
	            
	            if(indegree[i] == 0){
	               
	                q.add(i);
	            }
	            
	        }
	        
	       
	        
	        int count=0;
	       int minCnt =0;
	        
	        while(!q.isEmpty()){
	            int size=q.size();
	            for(int i=0; i<size; i++){
	            int u = q.poll();
	            count++;
	            for(int node : adj[u]){
	                if(--indegree[node] == 0)
	                    q.add(node);
	            }
	            }
	            minCnt++;
	        }
	        
	        //if count not equal to all courses then there will be a cycle.
	        if(count != n)
	            return -1;
	        return minCnt;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
