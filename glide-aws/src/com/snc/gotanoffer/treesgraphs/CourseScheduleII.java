package com.snc.gotanoffer.treesgraphs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
	
	//#ofcourses =4 
	//prereq: [ [1,0] , [2,0] , [3,1] , [3,2] ]
	
//	0 index:[ 1 ,2 ]
//	1 index: [3]
//	2 index: [3]
//	3 index []
	
	//once we build a map go to each index and mark it as visited and go to their neighbours and again each neighbour each any dependencies on those
	//and add it to result string
	/*
	 *     
    //Time Complexity: O(V + E)O(V+E) where VV represents the number of vertices and EE 
     * represents the number of edges. We pop each node exactly once from the zero in-degree 
     * queue and that gives us VV. Also, for each vertex, we iterate over its adjacency 
     * list and in totality, we iterate over all the edges in the graph which gives us EE. 
     * Hence, O(V + E)O(V+E)
Space Complexity: O(V + E)O(V+E). We use an intermediate queue data structure to 
keep all the nodes with 0 in-degree. In the worst case, there won't be any prerequisite 
relationship and the queue will contain all the vertices initially since all of them will have 0 in-degree. 
That gives us O(V)O(V). Additionally, we also use the adjacency list to represent our graph initially. 
The space occupied is defined by the number of edges because for each node as the key, we have all its adjacent 
nodes in the form of a list as the value. Hence, O(E)O(E). So, the overall space complexity is O(V + E).
	 */
	 private static boolean dfs(int u, List<Integer>[] adj, List<Integer> s, int[] visited){
	        visited[u] = 1;
	        for(int v : adj[u]){
	            if(visited[v] == 1) 
	                return true;
	            if(visited[v] == 0 && dfs(v, adj, s, visited)) 
	                return true;
	        }
	        visited[u] = 2;
	        s.add(u);
	        return false;
	    }
	    
	    public static  int[] findOrder(int numCourses, int[][] prerequisites) {
	        List<Integer>[] adj = new LinkedList[numCourses];
	        for(int i = 0; i < numCourses; ++i)
	            adj[i] = new LinkedList<Integer>(); //create an adjecency list
	        for(int[] courses: prerequisites)
	            adj[courses[1]].add(courses[0]); // go to prereq index in adjecency list and add course value
	        
	        List<Integer> s = new LinkedList();
	        int[] visited = new int[numCourses];
	        for(int i = 0; i < numCourses; ++i)
	            if(visited[i] == 0 && dfs(i, adj, s, visited)) 
	                return new int[0];
	        Collections.reverse(s);
	        int[] result = s.stream().mapToInt(Integer::intValue).toArray();
	        return result;
	    }
	    
	    


	public static void main(String[] args) {
		// TODO Auto-generated method stub
int numCourse =4;
int[][] prereq = { {1,0} , {2,0} , {3,1} , {3,2} };

findOrder(numCourse,prereq);
	}

}
