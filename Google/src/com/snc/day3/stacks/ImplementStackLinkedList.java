package com.snc.day3.stacks;

public class ImplementStackLinkedList {
	
	
	class Node{
		
		Node next;
		int data;
		Node(int val){
			data=val;
			next=null;
		}
	}
	
	private Node top;
	
	public void push(int val) {
		Node temp = new Node(val);
		 temp.next=top;
		 top=temp;
	    
		
	}
	
	
	public int pop(int val) throws Exception {
		if(isEmpty()) 
				throw new Exception();
		
		int value = top.data;
		top=top.next;
		
		return value;
			
		
	}
	
	public boolean isEmpty() {
		
		return top == null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
