package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.SearchElementLinkedList.Node;

public class AddTwoNumbersWithOutStack {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	
	public static Node addTwoNumbers(Node A , Node B ) {
		if(A == null)
			return B;
		if(B == null)
			return A;
		
		
		
		Node newA = reverse(A);
		Node newB = reverse(B);
		
		Node res = null;
		int carry=0;
		int sum=0;
		
		while(newA != null || newB != null) {
			sum=0;
			if(newA != null) {
				sum+=newA.val;
				newA=newA.next;
			}
				
			if(newB != null) {
				sum+=newB.val;
				newB=newB.next;
			}
			
					sum+=carry;
					
			carry = sum/10;
			
			
		if(res == null)
			res=new Node(sum%10);
		else
		{
			Node temp=new Node(sum%10);
			temp.next=res;
			res=temp;
		}
			
	
		
		}
		
		if(carry > 0) {
			Node temp = new Node(carry);
			temp.next=res;
			return temp;
		}
		
		return res;
		
	}
	
	
	public static Node reverse(Node n ) {
		
		Node newNode = null;
		
		while(n != null) {
			
			Node temp = n;
			n=n.next;
			
			temp.next=newNode;
			newNode=temp;
		}
		
		return newNode;
	}
	
	
	public static Node addTwoNumbersFront(Node newA , Node newB ) {
		if(newA == null)
			return newB;
		if(newB == null)
			return newA;
		
		
		
//		Node newA = reverse(A);
//		Node newB = reverse(B);
		
		Node res = null;
		int carry=0;
		int sum=0;
		Node dummy = new Node(0);
		Node curr=dummy;
		while(newA != null || newB != null) {
			sum=0;
			if(newA != null) {
				sum+=newA.val;
				newA=newA.next;
			}
				
			if(newB != null) {
				sum+=newB.val;
				newB=newB.next;
			}
			
					sum+=carry;
					
			carry = sum/10;
			
			
		
		curr.next=new Node(sum%10);
		
	     curr=curr.next;
		
		}
		
		if(carry > 0) {
			curr.next=new Node(carry);
		}
		
		return dummy.next;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node A = new Node(2);
		A.next=new Node(4);
		A.next.next = new Node(3);
		
		Node B = new Node(5);
		B.next=new Node(6);
		B.next.next = new Node(4);
		
	Node rr=	addTwoNumbersFront(A , B);
	
	while(rr!= null ) {
		System.out.print(rr.val);
		rr = rr.next;
	}
		
		

	}

}
