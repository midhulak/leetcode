package com.snc.phone.linkedlists;

public class ReorderList {
	
	 
    /*
    https://leetcode.com/problems/reorder-list/
    Complexity Analysis

Time complexity: \mathcal{O}(N)O(N). There are three steps here. To identify the middle node takes \mathcal{O}(N)O(N) time. To reverse the second part of the list, one needs N/2N/2 operations. The final step, to merge two lists, requires N/2N/2 operations as well. In total, that results in \mathcal{O}(N)O(N) time complexity.

Space complexity: \mathcal{O}(1)O(1), since we do not allocate any additional data structures.



*/
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
    public void reorderList(ListNode head) {
        
        if(head == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast=fast.next.next;
        }
        
        //slow will be at mid ..want to reverse taht
        
        ListNode curr = slow;
        
      ListNode NewHead=null;
        while(curr != null){
        ListNode temp = curr;
            curr=curr.next;
            temp.next = NewHead;
            NewHead=temp;
        }
        
        
    //now combine first elements to reverse node which is newhead
        
        ListNode first = head;
        ListNode second = NewHead;
        
        while(second.next != null) {
            
            ListNode temp = first.next;
            first.next=second;
            first=temp;
            
            temp=second.next;
            second.next=first;
            second=temp;
            
        }
        
    }

}
