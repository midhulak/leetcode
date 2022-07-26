package com.snc.day3.linkedlists.singleLinkedLists;

import com.snc.day3.linkedlists.singleLinkedLists.LengthLinkedList.Node;

public class SearchElementLinkedList {
	
	static class Node{
		Node next;
		int val;
		Node(int val){
			this.val = val;
		}
	}
	
	
	public static int searchIterative(Node head , Node search) {
	
		
		for(int i=0 ; head!=null; i++) {
			
			if(head.val == search.val)
				return i;
			head=head.next;
		}
		return -1;
	}
	
	public static int searchRecursive(Node head , Node search, int position) {
		
		  if(head == null)
			return -1;
					
					if(head.val == search.val)
						return position;
					
				return	searchRecursive(head.next , search,  position+1);	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		n.next.next.next = new Node(4);

		System.out.println("iterative=="+searchIterative(n , new Node(5)));
		
		System.out.println("recursive=="+searchRecursive(n , new Node(0) , 0));
	}

}
