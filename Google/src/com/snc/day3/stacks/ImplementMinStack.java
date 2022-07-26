package com.snc.day3.stacks;

import java.util.Stack;

public class ImplementMinStack {

	
	static Stack<int[]> stack = new Stack<>();
	
	
	
	public static void push(int val) {
		
		if(stack.isEmpty()) {
			stack.push(new int[] {val , val});
			return;
		}
		
		int currentMin = stack.peek()[1];
		
		stack.push(new int[]{val , Math.min(val, currentMin)});
	}
	
	public static void pop() {
		
		
		 stack.pop();
	}
	
	public static int top() {
		return stack.peek()[0];
	}
	
	public static int getMin() {
		return stack.peek()[1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementMinStack.push(7);
		ImplementMinStack.push(9);
		ImplementMinStack.push(3);
		System.out.println("Min is="+getMin());
		ImplementMinStack.pop();
		System.out.println("Min is="+getMin());
		ImplementMinStack.pop();
		System.out.println("Min is="+getMin());
		

	}

}
