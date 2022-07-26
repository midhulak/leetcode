package com.snc.arrays;


//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
 * @author midhula.kadiyala
 *
 */

public class RemoveAdjacentDuplicatesStringII {
	
	  class Node {
	        char ch;
	        int times;
	        public Node(char c, int t) {
	            ch = c;
	            times = t;
	        }
	    }

	    public String removeDuplicates(String s, int k) {
	        int n = s.length();
	        if (n < k) return s;
	        Deque<Node> stack = new ArrayDeque<>();

	        for (char c : s.toCharArray()) {
	            //if stack is not empty and prev element is not equal to current element store that element in stack
	            if (stack.isEmpty() || c != stack.peek().ch) {
	                stack.push(new Node(c, 1));
	            } else {
	                //if previous elemnet is equal to currnet element check this element an dptrev element count is equal to k
	                int repeated = stack.peek().times;

	                //if curre element and prev element count is equal to k then remove from stack
	                if (k == repeated + 1) {
	                    stack.pop();
	                } else {
	                    //otherwise the element is same and just increment how many times that elemnet is repeated.
	                    stack.peek().times++;
	                }
	            }
	        }

	        StringBuilder sb = new StringBuilder();
	        for (Node node : stack) {
	            int repeated = node.times;
	            for (int i = 0; i < repeated; i++) {
	                sb.append(node.ch);
	            }
	        }

	        return sb.reverse().toString();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
