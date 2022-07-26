package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.DeleteLinkedList.Node;

public class LengthLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static int iterativeLen(Node head) {
		int count=0;
		
		
		while(head != null) {
			count++;
			head = head.next;
		}
		
		return count;
	}

	
	
	public static int recursiveLen(Node head) {
		if(head == null)
			return 0;
		
     return 1+recursiveLen(head.next);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		
		System.out.println("Iterative Length="+iterativeLen(n));
		System.out.println("Recursive Length="+recursiveLen(n));

	}

}
