package com.snc.leetcodechallenges.feb;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
	
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	 public Node copyRandomList(Node n) {
	        if (n == null) return n;
	        
	        Map<Node , Node> nodeMap = new HashMap<>();
	        Node currentNode = n;
	        //first iterate teh whole list and add nodes to teh map
	        while(currentNode != null){
	            nodeMap.put(currentNode , new Node(currentNode.val));
	            currentNode = currentNode.next;
	        }
	        
	        //Fix next and random pointers
	        currentNode = n;
	        
	        while(currentNode != null){
	            nodeMap.get(currentNode).next = currentNode.next != null ? nodeMap.get(currentNode.next) : null;
	            
	            nodeMap.get(currentNode).random = currentNode.random != null ? nodeMap.get(currentNode.random) : null;
	            currentNode = currentNode.next;
	        }
	        
	       return nodeMap.get(n);
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
