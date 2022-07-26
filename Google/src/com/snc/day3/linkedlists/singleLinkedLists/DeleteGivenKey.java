package com.snc.day3.linkedlists.singleLinkedLists;

public class DeleteGivenKey {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	
	public static Node deleteGivenKey(Node head , Node n) {
		
		
		Node prev = null;
		
		if(head != null && head.val == n.val) {
			
			head = head.next;
			
			return head;
		}
		Node temp = head;
		
		while(head.next != null && head.next.val != n.val) {
			
			prev=head.next;
			head=head.next;
			
		}
		
		if(head.next.next != null)
		prev.next = head.next.next;
		
		else
			prev.next = null;
		
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Node n = new Node(1);
	n.next = new Node(2);
	n.next.next = new Node(3);
	n.next.next.next = new Node(4);
	
	Node res = deleteGivenKey(n , new Node(3));
	
	while(res != null) {
		System.out.println(res.val);
		res=res.next;
	}

	}

}
