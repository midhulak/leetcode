package com.snc.arrays;

import java.util.Stack;

public class SimplifyAlgebraic {
	
	static String simplify(String str)
	{
	    int len = str.length();
	 
	    // resultant string of max length equal
	    // to length of input string
	    char res[] = new char[len];
	    int index = 0, i = 0;
	 
	    // create empty stack
	    Stack<Integer> s = new Stack<Integer> ();
	    s.push(0);
	 
	    while (i < len) {
	          // Don't do any operation
	        if(str.charAt(i) == '(' && i == 0) {
	            i++;
	              continue;
	        }
	       
	        if (str.charAt(i) == '+') {
	 
	            // If top is 1, flip the operator
	            if (s.peek() == 1)
	                res[index++] = '-';
	 
	            // If top is 0, append the same operator
	            if (s.peek() == 0)
	                res[index++] = '+';
	 
	        } else if (str.charAt(i) == '-') {
	            if (s.peek() == 1)
	                res[index++] = '+';
	            else if (s.peek() == 0)
	                res[index++] = '-';
	        } else if (str.charAt(i) == '(' && i > 0) {
	            if (str.charAt(i - 1) == '-') {
	 
	                // x is opposite to the top of stack
	                int x = (s.peek() == 1) ? 0 : 1;
	                s.push(x);
	            }
	 
	            // push value equal to top of the stack
	            else if (str.charAt(i - 1) == '+')
	                s.push(s.peek());
	        }
	 
	        // If closing parentheses pop the stack once
	        else if (str.charAt(i) == ')')
	            s.pop();
	               
	        else if(str.charAt(i) == '(' && i == 0)
	              i = 0;
	        // copy the character to the result
	          else
	            res[index++] = str.charAt(i);
	        i++;
	    }
	    return new String(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "(a-(b+c)+d)";
	   // String s2 = "a-(b-c-(d+e))-f";
	    System.out.println(simplify(s1));
	  // System.out.println(simplify(s2));

	}

}
