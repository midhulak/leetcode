package com.snc.day3.linkedlists.singleLinkedLists;


public class NNodeLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	
	public static Node fndNNode(Node head , int position) {
		
		for(int i=0 ; head != null ; i++) {
			
			if(i == position)
				return head;
			
			head=head.next;
		}
		
		return null;
	}
	
	public static Node fndNNodeRecursion(Node head , int position , int start) {
		
		if(head == null)
			return null;
		
		
		         if(start == position)
		        	 return head;
		       
		     return    fndNNodeRecursion(head.next , position , start+1);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);
		
		
		Node res = fndNNode(n , 2);
		System.out.println(res.val);
		Node res1 = fndNNodeRecursion(n , 3 , 0);
		System.out.println(res1.val);
		
		
		
		
	}

}
