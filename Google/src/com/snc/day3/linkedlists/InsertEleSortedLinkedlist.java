package com.snc.day3.linkedlists;

public class InsertEleSortedLinkedlist {
	
	static class Node{
		
		int data;
		
		Node next;
		
		Node(int val){
			this.data = val;
		}
		
	}
	
	static Node insertInSortedOrder(Node h, int val) 

	{ 

	Node temp = new Node(val); 

	 

	if(h == null || h.data > val){ 

	temp.next = h; 

	return temp; 

	} 

	Node origH = h; 

	while(h.next != null && h.next.data < val) {
		System.out.println(h.next.data);
	    h = h.next; 
	}
	
	temp.next = h.next; 
    h.next = temp; 

		
    return origH; 

	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n = new Node(5);
		n.next = new Node(10);
		n.next.next = new Node(15);
		
		insertInSortedOrder(n , 12);
		
	}

}
