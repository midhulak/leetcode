package com.snc.arrays;

import java.util.Stack;

public class BasicCalculator {
	

	    public static int evaluateExpr(Stack<Object> stack) {

	        int res = 0;

	        if (!stack.empty()) {
	            res = (int) stack.pop();
	        }

	        // Evaluate the expression till we get corresponding ')'
	        while (!stack.empty() && !((char) stack.peek() == ')')) {

	            char sign = (char) stack.pop();

	            if (sign == '+') {
	                res += (int) stack.pop();
	            } 
	            else if(sign == '*') {
	            	res *= (int) stack.pop();
	            }
	            else {
	                res -= (int) stack.pop();
	            }
	        }
	        return res;
	    }

	    public static int calculate(String s) {

	        int operand = 0;
	        int n = 0;
	        Stack<Object> stack = new Stack<Object>();

	        for (int i = s.length() - 1; i >= 0; i--) {

	            char ch = s.charAt(i);

	            if (Character.isDigit(ch)) {

	                // Forming the operand - in reverse order. if it is 2 or more digits need to append to right side digit
	            	//for eg: 128 we are doing it from reverse order first will get 8 next will get 2 then it is 28 next will get 1 then it is 128 and n=3
	                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
	                System.out.println("operand="+operand);
	                n += 1;

	            } else if (ch != ' ') {
	                if (n != 0) {
	//once we see operand then we iterated whole digit then push that operand to stack and mark n to 0
	                    // Save the operand on the stack
	                    // As we encounter some non-digit.
	                    stack.push(operand);
	                    n = 0;
	                    operand = 0;

	                }
	                if (ch == '(') {

	                    int res = evaluateExpr(stack);
	                    stack.pop();

	                    // Append the evaluated result to the stack.
	                    // This result could be of a sub-expression within the parenthesis.
	                    stack.push(res);

	                } else {
	                    // For other non-digits just push onto the stack.
	                    stack.push(ch);
	                }
	            }
	        }

	        //Push the last operand to stack, if any.
	        if (n != 0) {
	            stack.push(operand);
	        }

	        // Evaluate any left overs in the stack.
	        return evaluateExpr(stack);
	    }

	    
	    public static int basicCalculate(String s) {
	        s = s.trim().replaceAll(" ","");
	        s = s.replaceAll("\\(","");
	        s = s.replaceAll("\\)","");
	        String[] nums = s.split("[\\+\\-\\*/]+");
	        String[] ops = s.split("[\\d]+");
	        Stack<Integer> numsStack = new Stack<Integer>();
	        numsStack.push(Integer.parseInt(nums[0]));
	        for (int i = 1; i < ops.length; i ++) {
	            int curr = Integer.parseInt(nums[i]);
	            if (ops[i].equals("*")) {
	                curr = numsStack.pop() * curr;
	            }
	            if (ops[i].equals("/")) {
	                curr = numsStack.pop() / curr;
	            }
	            if (ops[i].equals("-")){
	                curr = -curr;
	            }
	            if (ops[i].equals("+")){
	                curr = +curr;
	            }
	            numsStack.push(curr);
	        }
	        int result = 0;
	        while (numsStack.size() > 0) {
	            result += numsStack.pop();
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        //assert calculate("1 + 1") == 2;
	       // assert calculate(" 2-1 + 2 ") == 3;
	        //assert calculate("(1+(4+5+2)-3)+(6+8)") == 23;
	    	//calculate("1 + 1");
	    	//4+3*4=16
	    	System.out.println(basicCalculate("(1+(4*5+2)-3)+(6+28)"));
	       // System.out.println("Passed all test cases");
	    }

	}


	

