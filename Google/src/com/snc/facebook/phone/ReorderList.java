package com.snc.facebook.phone;

public class ReorderList {
	
	  public void reorderList(ListNode head) {
	        if(head == null)
	            return;
	        
	        //find the middle of linkedlist using slow and fast pointers
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast!= null && fast.next != null){
	            
	            slow = slow.next;
	            fast=fast.next.next;
	        }
	        
	        //reverse the second part of teh list 
	        
	        //and second part starts with slow node so
	            ListNode NewHead = null;
	        ListNode curr = slow;
	      
	        while(curr != null){
	        ListNode temp = curr;
	            curr=curr.next;
	            temp.next = NewHead;
	            NewHead=temp;
	        }
	           
	        //now our prev node is head of second part then need to merge both first part and second part
	     
	        ListNode first=head;
	        ListNode second = NewHead;
	        
	        while(second.next != null){
	            
	            ListNode tmp = first.next;
	            first.next=second;
	            first=tmp;
	            
	            tmp = second.next;
	            second.next= first;
	            second =tmp;
	            
	            
	        }
	            
	    }

}
