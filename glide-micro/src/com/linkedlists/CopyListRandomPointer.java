package com.linkedlists;

import java.util.HashMap;

/**https://www.youtube.com/watch?v=Py6tPf74Kyc&t=976s **/
import java.util.Map;

public class CopyListRandomPointer {
	
	static class Node{
		
		Node next;
		Node random;
		int val;
		
		Node(int val){
			this.val = val;
		}
	}
	
public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;
        Node currentNode = head;
        
    //Create a copy of pointers in a map
        Map<Node , Node> map = new HashMap<>();
        
        while(currentNode != null){
            map.put(currentNode , new Node(currentNode.val));
            currentNode=currentNode.next;
        }
        
        
        //Fix the next pointers 
        currentNode = head;
        
        while(currentNode != null){
            
            map.get(currentNode).next = currentNode.next != null ? map.get(currentNode.next) : null;
            map.get(currentNode).random = currentNode.random != null ?  map.get(currentNode.random) : null;
            currentNode = currentNode.next;
            
        }
        //need to return the head pointer in head and which of all is conected
        return map.get(head);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
