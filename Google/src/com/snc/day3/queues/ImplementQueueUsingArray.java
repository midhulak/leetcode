package com.snc.day3.queues;

public class ImplementQueueUsingArray {
	
	int front;
	int rear;
	int capacity;
	int arr[];
	
	public ImplementQueueUsingArray(int capacity) {
		this.front=0;
		this.rear=0;
		this.capacity = capacity;
		arr=new int[capacity];
	}
	
	
	public void enQueue(int val) throws Exception{
		
		if(isFull())
			throw new Exception();
		
		arr[rear] = val;
		rear++;
		
	}
	
	public int deQueue() throws Exception{
		
		if(isEmpty()) throw new Exception();
		
		int retVal= arr[front];
	    for(int i=0 ; i<rear-1; i++) {
		arr[i] = arr[i+1];
	    }
	    
	    if(rear < capacity)
	    	arr[rear] = 0;
		return retVal;
	}
	
	public boolean isFull() {
		
		return rear == capacity;
		
	}
	
	
     public boolean isEmpty() {
		
		return front == rear;
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ImplementQueueUsingArray dd = new ImplementQueueUsingArray(10);
		dd.enQueue(5);
		dd.enQueue(8);
		dd.enQueue(9);
		
		System.out.println(dd.deQueue());
		System.out.println(dd.deQueue());
		
	}

}
