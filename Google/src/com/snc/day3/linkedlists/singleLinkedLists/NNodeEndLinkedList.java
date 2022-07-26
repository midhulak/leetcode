package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.DeleteLinkedList.Node;

public class NNodeEndLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node  NNodeEndOfLinkedList(Node head , int k) {
		if(head == null)
			return null;
		
		Node current = head;
		Node follower = head;
		
		while(current != null && k > 0) {
			current=current.next;
			k--;
		}
		
		while(current != null) {
			current=current.next;
			follower=follower.next;
		}
		//to remove
		//return deleteNode(head , follower);
		return head;
	}

	
	public static Node deleteNode(Node head , Node delete) {
Node prev = head;
		
		if(head != null && head == delete) {
			
			head = head.next;
			
			return head;
		}
		Node temp = head;
		
		while(head.next != null && head.next != delete) {
			
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

		Node res = NNodeEndOfLinkedList(n , 1);
		System.out.println("value is="+res.val);
		while(res != null) {
			System.out.println(res.val);
			res=res.next;
		}
		
		
	}

}
