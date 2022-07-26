package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.NNodeEndLinkedList.Node;

public class MiddleLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static int middleLinkedList(Node head) {
		
	Node slow=head;
	Node fast=head;
	
	while(fast != null && fast.next != null) {
		slow=slow.next;
		fast=fast.next.next;
	}
		
	return slow.val;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		n.next.next.next.next = new Node(5);
		
		System.out.println(middleLinkedList(n));

	}

}
