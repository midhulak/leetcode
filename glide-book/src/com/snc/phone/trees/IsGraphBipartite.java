package com.snc.phone.trees;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
	
	
public boolean isBipartite(int[][] graph) {
        
        /**
        https://leetcode.com/problems/is-graph-bipartite/
        Time Complexity: O(N + E)O(N+E), where NN is the number of nodes in the graph, and EE is the number of edges. We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.

Space Complexity: O(N)O(N), the space used to store the color.

*/
        
        
        //try to take an array of colors
        int color[] = new int[graph.length];
        
        Queue<Integer> queue = new LinkedList<>();
        
        
        for(int i=0 ; i<graph.length; i++){
            
            if(color[i] != 0)
                continue;
            //add first nod einto graph by add ing some color eg: 1 is. red color
            color[i]=1;
            queue.add(i);
        while(!queue.isEmpty()){
            //take out node from queue
            int currNode = queue.poll();
            //try to see the adjacent colors of node having the same color as the current node if same color we immediately say graph is not bipartite
            //if color is not assigned that means 0 then add opposite color to that and again add it to the queue and repeat this till to the end.
            for(int adj : graph[currNode]){
                
                if(color[adj] == color[currNode])
                    return false;
                
                if(color[adj] == 0){
                    color[adj] = -color[currNode];
                    queue.add(adj);
                }
                
                
            }
            
        }
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
