package com.linkedlists;

public class ReverseLinkedList {
	
	static class ListNode{
		ListNode next;
		ListNode prev;
		int val;
	}
	
public ListNode reverseList(ListNode head) {
        
        ListNode current = head;
        ListNode prev = null;
        
        while(current != null){
            ListNode temp = current.next;
            current.next=prev;
            prev=current;
            current=temp;
            
        }
        
        return prev;
    }



public static ListNode  reverseListRecursive(ListNode head) {
 /* Recursive algorithm to reverse nodes in linked list. 
     Time complexity: O(n).
     Space complexity: O(n).
  */
	System.out.println(head.val);
 if (head == null || head.next == null) {
 	return head;
  
 }
 ListNode p = reverseListRecursive(head.next);

 head.next.next = head;
 head.next = null;
 return p;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
