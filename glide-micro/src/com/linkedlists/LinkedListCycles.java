package com.linkedlists;



public class LinkedListCycles {
	
	static class Node{
		int val;
		Node next;
	}
	
	public boolean hasCycleFloyd(Node n) {
	    if (n == null) return false;
	    Node slow = n;
	    Node fast = n.next;
	        
	    while (fast != null && fast.next != null) {
	        if (fast == slow) return true;
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	        
	    return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
