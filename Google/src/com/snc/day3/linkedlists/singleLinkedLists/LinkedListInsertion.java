package com.snc.day3.linkedlists.singleLinkedLists;

public class LinkedListInsertion {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public Node insertLinkedList(Node head , int val) {
		
		Node temp = new Node(val);
		
			temp.next=head;
			return temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
