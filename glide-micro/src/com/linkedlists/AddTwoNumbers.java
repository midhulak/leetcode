package com.linkedlists;

import java.util.Stack;
//reverse digits add it and reverse the result
public class AddTwoNumbers {
	
	static class ListNode{
		ListNode next;
		int val;
		
		ListNode(int val){
			this.val = val;
		}
	}
	
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       Stack<Integer> s1 = new Stack<Integer>();
       Stack<Integer> s2 = new Stack<Integer>();

       while(l1 != null) {
           s1.push(l1.val);
           l1 = l1.next;
       };
       while(l2 != null) {
           s2.push(l2.val);
           l2 = l2.next;
       }

       int sum = 0;
       ListNode list = new ListNode(0);
       while (!s1.empty() || !s2.empty()) {
           if (!s1.empty()) sum += s1.pop();
           if (!s2.empty()) sum += s2.pop();
           list.val = sum % 10;
           ListNode head = new ListNode(sum / 10);
           head.next = list;
           list = head;
           sum /= 10;
       }

       return list.val == 0 ? list.next : list;
   }
	 
	 public static  ListNode addTwoNumbersII(ListNode l1 , ListNode l2){
	        ListNode dummyHead = new ListNode(0);
	        ListNode p =l1, q=l2, curr = dummyHead;
	        
	        int carry=0;
	        
	        while(p != null || q != null){
	            int x = (p != null) ? p.val : 0;
	            int y = (q != null) ? q.val : 0;
	            
	            int sum = carry + x +y;
	            carry = sum/10;
	            
	            curr.next = new ListNode(sum % 10);
	            curr = curr.next;
	            
	            if(p != null)
	                p = p.next;
	            
	           if(q != null)
	                q = q.next;
	            
	            
	        }
	        
	        if(carry > 0){
	            curr.next = new ListNode(carry);
	        }
	        return dummyHead.next;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
