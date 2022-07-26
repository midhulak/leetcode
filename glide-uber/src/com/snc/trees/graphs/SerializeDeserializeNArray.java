package com.snc.trees.graphs;

import java.util.LinkedList;
import java.util.List;


/**https://www.youtube.com/watch?v=qk3JNkcdm0o**/
public class SerializeDeserializeNArray {
	
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	
	 public String serialize(Node root) {
	        StringBuilder sb = new StringBuilder();
	        serialize(sb , root);
	        return sb.toString();
	        
	    }
	    
	    public void serialize(StringBuilder sb , Node root){
	        
	        sb.append(root.val);
	        
	        for(Node child : root.children){
	            serialize(sb , child);
	        }
	        sb.append("null");
	        
	    }
	    
	    
	    
		
	    // Decodes your encoded data to tree.
	    // public Node deserialize(String data) {
	    //    if(data.isEmpty())
	    //        return null;
	    //     int[] i = new int[1];
	    //     return deser(data.split(",") , i);
	    // }
	    
	    
	   public Node deserialize(String data) {
	        if(data.isEmpty()) {
	            return null ;
	        }
	       String[] arr = data.split(",");

	        LinkedList<Node> list = new LinkedList<>();
	       
	       for(int i =0; i<arr.length-1; i++){
	           
	           if(arr[i].equals("null")){
	               Node toRemove = list.removeFirst();
	               
	               list.getFirst().children.add(toRemove);
	           }
	           else
	           {
	               Node node = new Node(Integer.parseInt(arr[i]));
	               
	               list.addFirst(node);
	           }
	           
	       }
	       
	      return  list.removeFirst();
	       
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
