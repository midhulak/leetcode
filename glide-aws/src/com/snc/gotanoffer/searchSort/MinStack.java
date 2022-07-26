package com.snc.gotanoffer.searchSort;

import java.util.Stack;

//Let nn be the total number of operations performed.
//
//Time Complexity : O(1)O(1) for all operations.
//
//push(...): Checking the top of a Stack, comparing numbers, and pushing to the top of a Stack (or adding to the end of an Array or List) are all O(1)O(1) operations. Therefore, this overall is an O(1)O(1) operation.
//
//pop(...): Popping from a Stack (or removing from the end of an Array, or List) is an O(1)O(1) operation.
//
//top(...): Looking at the top of a Stack is an O(1)O(1) operation.
//
//getMin(...): Same as above. This operation is O(1)O(1) because we do not need to compare values to find it. If we had not kept track of it on the Stack, and instead had to search for it each time, the overall time complexity would have been O(n)O(n).
//
//Space Complexity : O(n)O(n).
//
//Worst case is that all the operations are push. In this case, there will be O(2 \cdot n) = O(n)O(2⋅n)=O(n) space used.

public class MinStack {
	

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    Stack<int[]> stack = new Stack<>();
    public void push(int x) {
        //if stack empty just inserting it we have 2 index int array o index have exact val of 
    	//stack and 1index always maintains teh min value
        if(stack.isEmpty()){
            
            stack.push(new int[]{x,x});
            return;
        }
        
     
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x , Math.min(x,currentMin)});
        
            
    }
    
    public void pop() {
    stack.pop();
        
    }
   
    public int top() {
       return stack.peek()[0];
    }
    //min value of stack
    public int getMin() {
       return  stack.peek()[1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
