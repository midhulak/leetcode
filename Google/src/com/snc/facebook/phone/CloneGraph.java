package com.snc.facebook.phone;

public class CloneGraph {

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
