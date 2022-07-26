package com.snc.day3.linkedlists.singleLinkedLists;



public class DeleteLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node deleteLinkedList(Node head) {
		
		if(head != null) {
			head = null;
			return head;
		}
		
		return head;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		
		Node res = deleteLinkedList(n);
		while(res != null) {
			System.out.println(res.val);
			res=res.next;
		}
		
		
	}

}
