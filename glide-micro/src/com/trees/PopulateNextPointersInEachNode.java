package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointersInEachNode {
	
	static class Node{
		Node left;
		Node right;
		Node next;
		int val;
	}
	
	 public Node connect(Node root) {
	        
	        if(root == null)
	            return null;
	        
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        queue.add(null);
	        
	        while(!queue.isEmpty()){
	       
	                Node temp = queue.remove();
	                
	                if(temp == null && queue.isEmpty())
	                    return root;
	            
	            else if(temp == null){
	                queue.add(null);
	                continue;
	            }
	                else{
	                    temp.next = queue.peek();
	                if(temp.left != null)
	                    queue.add(temp.left);
	                
	                if(temp.right != null)
	                    queue.add(temp.right);
	            }
	        }
	           return root;
	        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
