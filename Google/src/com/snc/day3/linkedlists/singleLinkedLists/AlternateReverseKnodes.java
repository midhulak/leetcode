package com.snc.day3.linkedlists.singleLinkedLists;



public class AlternateReverseKnodes {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	static class Pair{
		Node h;
		Node t;
		Node headtail;
	}
	
	public static Node KReverseAlternate(Node head , int k) {
		
		if(head == null || k == 0 )
			return head;
		
	Node OrHead = head;
	
	Node newHead = null;
	int count=0;
	
	while(head != null && count<k) {
		
		Node temp = head;
		head = head.next;  
		temp.next=newHead;
		newHead=temp;
		count++;
	}
	
	if(OrHead != null)
		OrHead.next=head;
	
	
		while(head != null && count > 1)
		{
			head = head.next;
			count--;
		}
	
		if(head != null) {
			head.next = KReverseAlternate(head.next , k);
		}
		
		return newHead;
	}
	
	
	public static Node KReverseAlternateIterative(Node head , int k) {
		
		if(head == null || k == 0)
			return head;
		int count=0;
		
		
		Node newHead = null;
		Node tail = head;
	 
		
//			while(head != null && count<k) {
//				Node temp = head;
//				head= head.next;
//				
//				temp.next=newHead;
//				newHead=temp;
//				count++;
//			}
		Pair p1 =reverseKNodes(head , k);
		if(p1 != null) {
		 newHead = p1.h;
		  tail=p1.t;
		  head=tail;
		}
		 
		   
		
		while(head != null) {
			count=k;
		while(head != null && count > 1) {
			
			head=head.next;
			tail=tail.next;
			count--;
		}
		if(head != null) {
		Pair p = reverseKNodes(head.next , k);
		if(p != null) {
		tail.next=p.h;
		
		head=p.t;
		}
		}

	}
	
		return newHead;
	}
	
	
	public static Pair reverseKNodes(Node head , int k) {
		
		if(head == null)
			return null;
		int count=0;
		Node newHead=null;
		Node OrH = head;
		Pair p = new Pair();
		
		while(head != null && count<k) {
			
			Node temp = head;
			head = head.next;  
			temp.next=newHead;
			newHead=temp;
			count++;
		}
		
		OrH.next=head;
		p.h=newHead;
		p.t = head;
		return p;
	}
	
	
	
	
	
	
	public static Node insertKElements(int k) {
		
		Node head = new Node(1);
		Node Orhead= head;
		
		for(int i=2; i<k; i++) {
			head.next=new Node(i);
			head=head.next;
		}
		
		return Orhead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Node head= insertKElements(13);
		
	   System.out.println(head.val);
//		while(head != null) {
//			System.out.println(head.val);
//			head=head.next;
//		}
	   
	   
//	   Node n = new Node(3);
//	   n.next=new Node(4);
//	   n.next.next=new Node(5);
//	   
//	   Node k = new Node(6);
//	   k.next=new Node(7);
//	   k.next.next=new Node(8);
//	   
	  // appendResult(n , k);
		
	Node res1=	KReverseAlternateIterative(head , 3);
	Node res = KReverseAlternate(head , 3);
	
	while(res != null) {
	System.out.println("res////"+res.val);
	res=res.next;
}
		
	}

}
