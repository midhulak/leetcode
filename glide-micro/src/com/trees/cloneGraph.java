package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cloneGraph {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	
public Node cloneGraph(Node node) {
        
        if(node == null)
            return null;
        
        Map<Node , Node> visited = new HashMap<>();
        
        
        return DFS(node , visited);
        
        
    }
    
    
    public Node DFS(Node node , Map<Node, Node> visited ){
        
        if(visited.containsKey(node)){
            
          return visited.get(node);
        }
       
        Node cloneNode = new Node(node.val , new ArrayList());
        visited.put(node, cloneNode);
        
        for(Node adjNode : node.neighbors){
            
            
           cloneNode.neighbors.add(DFS(adjNode , visited));
        }
        return cloneNode;
    }

}
