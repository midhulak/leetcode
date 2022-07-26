package com.snc.Trees.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class CousesSchedculeII {
	
	
	
	
	public int[] findOrderUisngMap(int[][] prerequisites , int numCourses) {
		
		Map<Integer , List<Integer>> preReqMap = new HashMap<>();
		Map<Integer , Integer> indeg = new HashMap<>();
		
		buildPreReqMap(preReqMap , prerequisites);
		
		buildAndLoadIndegreeMap(indeg ,prerequisites, preReqMap);
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[numCourses];
		
		for(Entry<Integer, Integer> map: indeg.entrySet()) {
				if(map.getValue() == 0)
				queue.add(0);
		}
		int count=0;
		
		while(!queue.isEmpty()) {
			
			int course = queue.remove();
			result[count] = course;
			count++;
			
			if(preReqMap.get(course) == null)
				continue;
			for(Integer advanced : preReqMap.get(course)) {
				if(indeg.containsKey(advanced)) {
				indeg.put(advanced, indeg.get(advanced)-1);
				if(indeg.get(advanced)  == 0) {
					
					queue.add(advanced);
				}
				}
			}
			
		}
		System.out.println("count is="+count);
		
		if(count != numCourses)
			return null;
		
		else
			
			 return result;
		
		
		
	}
	
	        //0 -> [1,2]
			//1 ->[3]
			//2 -> [3]
	public void buildPreReqMap(Map<Integer , List<Integer>> preReqMap , int[][] prerequisites) {
           for(int[] req: prerequisites ) {
			
			if(preReqMap.containsKey(req[1])) {
				List<Integer> getList = preReqMap.get(req[1]);
				getList.add(req[0]);
				preReqMap.put(req[1], getList);
			}
			else {
				List<Integer> newList = new ArrayList<>();
				newList.add(req[0]);
				preReqMap.put(req[1], newList);
			}
			
		}
	}
	
	//adding all courses as keys after this indeg looks like thgis
	//0 -> 0
	//1->1
	//2->1
	//3->2
	public void buildAndLoadIndegreeMap(Map<Integer , Integer> indeg , int[][] prerequisites , Map<Integer , List<Integer>> preReqMap) {
		
		for(int[] req : prerequisites) {
			indeg.putIfAbsent(req[0], 0);
			indeg.putIfAbsent(req[1], 0);
			
		}
		
		for(Entry<Integer, List<Integer>> map : preReqMap.entrySet()) {
			
			for(Integer i : map.getValue()) {
				indeg.put(i, indeg.getOrDefault(i, 0)+1);
				
			}
		}
		
	}
	
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        
	       int[] result = new int[numCourses];
	        List<Integer> res = new ArrayList<Integer>();
	       //create an integer arary for each course
	        List<Integer> adj[] = new ArrayList[numCourses];
	        // //for each index in n create an arraylist
	        for(int i=0; i<numCourses; i++){
	            
	            adj[i] = new ArrayList<Integer>();
	        }
	        
	        int[] indegree = new int[numCourses];
	        //how many advance courseses are waiting to complete the base course
	        //map how many dependencies on each courese for eg [0,1] here to complete course 0 you have to take course 1 for for index [1] -> adding [0 as dependent curse]
	       //all aindeces are base courses and each base course how many dependencies are there just add 
//	      for eg:n [1,2] 1 and 2 courses are dependent on 0
//	        0
	        for(int[] preReq : prerequisites){
	            
	            adj[preReq[1]].add(preReq[0]);
	        }
	        
//all dependent courses just incremnt and and wharever index doe snot have dependency then that will be added to queue
	        for(int i=0; i<numCourses ; i++){
	            
	            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
	            
	            for(int node : temp)
	            indegree[node]++;
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        //if we see any base course wit out any dependency then adding it to the queue.
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
		CousesSchedculeII course = new CousesSchedculeII(); 
		
		int[][] prereqs = { {1,0} , {2,0} ,{3,1}, {3,2} };
		
		int[] result = course.findOrderUisngMap(prereqs , 4);
		if(result != null)
		for(int i=0; i< result.length; i++) {
			System.out.print(result[i]+" ");
		}

	}

}
