package com.snc.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        
	       int[] result = new int[numCourses];
	        List<Integer> res = new ArrayList<Integer>();
	        List<Integer> adj[] = new ArrayList[numCourses];
	        
	        for(int i=0; i<numCourses; i++){
	            
	            adj[i] = new ArrayList<Integer>();
	        }
	        
	        int[] indegree = new int[numCourses];
	        for(int[] preReq : prerequisites){
	            
	            adj[preReq[1]].add(preReq[0]);
	        }
	        
	        for(int i=0; i<numCourses ; i++){
	            
	            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
	            
	            for(int node : temp)
	            indegree[node]++;
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        for(int i=0; i<numCourses; i++){
	            if(indegree[i] == 0)
	                q.add(i);
	        }
	        
	       int count=0;
	        
	        while(!q.isEmpty()){
	            
	            int u = q.poll();
	            count++;
	           
	            res.add(u);
	         
	            
	            for(int node : adj[u]){
	                if(--indegree[node] == 0)
	                    q.add(node);
	                
	            }
	            
	        }
	        
	        if(count != numCourses)
	            return new int[]{};
	        
	        for(int i=0; i<res.size(); i++){
	            
	            result[i] = res.get(i);
	        }
	        
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
