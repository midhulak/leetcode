package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.DeleteGivenKey.Node;

public class DeleteNodeatgivenPosition {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node deleteNodePosition(Node head , int position) {
		
		if(head != null && position == 1) {
			head.next=null;
			return head;
		}
		
		Node orHead = head;
		Node prev=head;
		
		for(int i=2; head.next!=null; i++) {
			prev=head;
			if(i != position) {
				head=head.next;
			}
			else {
				prev.next=head.next.next;
			}
		}
		return orHead;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		
		Node res = deleteNodePosition(n , 5);
		
		while(res != null) {
			System.out.println(res.val);
			res=res.next;
		}
		
	}

}
