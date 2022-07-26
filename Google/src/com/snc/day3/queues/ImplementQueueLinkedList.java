package com.snc.day3.queues;

public class ImplementQueueLinkedList {
	
	static class Node{
		Node next;
		int data;
		Node(int val){
			this.data = val;
			next=null;
		}
		
		
	}
	Node head;
	Node tail;
	
	public ImplementQueueLinkedList() {
		this.head=null;
		this.tail=null;
	}
	
	public void enqueue(int val) {
		
		Node temp = new Node(val);
		if(tail == null) {
			this.head=temp;
			this.tail=temp;
			return;
		}
		
			this.tail.next=temp;
			tail=temp;
		
	}
	
	public int dequeue() throws Exception{
		
		if(isEmpty()) throw new Exception();
		
		Node temp = this.head;
	
		
		this.head = head.next;
		   
		   if(this.head == null)
			   this.tail = null;
		
		return temp.data;
	}

	
	public boolean isEmpty() {
		
		return tail == null;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
