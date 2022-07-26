package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.AddTwoNumbersWithOutStack.Node;

public class AddOneLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	public static Node AddoneTogivenNumber(Node A) {
		
		Node s=null;
		Node e=A;
		
		while(e != null) {
			if(e.val != 9) 
				s=e;
			e = e.next;
		}
		
		if(s == null) {
			Node temp = new Node(1);
			temp.next=A;
			
			while(A!=null) {
				A.val=0;
				A=A.next;
			}
			return temp;
		}
		else {
			s.val++;
			s=s.next;
			
			while(s != null) {
				s.val=0;
				s=s.next;
			}
			
		}
		
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node A = new Node(9);
		A.next=new Node(9);
		A.next.next = new Node(9);
		
		Node B = new Node(5);
		B.next=new Node(6);
		B.next.next = new Node(4);
		
	Node rr=	AddoneTogivenNumber(A);
	
	while(rr!= null ) {
		System.out.print(rr.val);
		rr = rr.next;
	}

	}

}
