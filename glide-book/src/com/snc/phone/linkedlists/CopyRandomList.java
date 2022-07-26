package com.snc.phone.linkedlists;

public class CopyRandomList {
	
	 /*
    Time Complexity : O(N)O(N) because we make one pass over the original linked list.
Space Complexity : O(N)O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are NN nodes, we have O(N)O(N) space complexity.
https://leetcode.com/problems/copy-list-with-random-pointer/solution/
*/
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
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
        
        return map.get(head);
    }

}
