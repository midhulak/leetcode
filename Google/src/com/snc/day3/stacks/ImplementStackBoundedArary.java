package com.snc.day3.stacks;

public class ImplementStackBoundedArary {
	
	int[] arr;
	int top;
	int n;
	
	ImplementStackBoundedArary(int n){
		this.n=n;
		this.top=-1;
	}
	
	
	public void push(int val) throws Exception{
		if(isFull())
			throw new Exception();
		
		arr[++top] = val;
		
	}
	
	public int pop() throws Exception{
		
		if(isEmpty()) throw new Exception();
		
		return arr[top--];
	}
	
	
	public boolean isEmpty() {
		
		return top == -1;
	}
	
	public boolean isFull() {
		return top == n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
