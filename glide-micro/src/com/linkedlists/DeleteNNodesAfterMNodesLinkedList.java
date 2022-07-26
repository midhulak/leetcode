package com.linkedlists;

public class DeleteNNodesAfterMNodesLinkedList {
	
	 public class ListNode {
		     int val;
		      ListNode next;
		      ListNode() {}
		     ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	 public ListNode deleteNodes(ListNode head, int m, int n) {
	       
	        ListNode newHead = head;
	        ListNode curr = newHead;
	        while(curr != null){
	            int count=0;
	            while(count < m-1 && curr != null){
	                curr = curr.next;
	            count+=1;
	            }
	            count=0;
	        
	       ListNode prevNode = curr;
	            if(curr != null)
	            curr=curr.next;
	           
	            while(count < n && curr != null){
	                curr = curr.next;
	                count+=1;
	            }
	            
	            if(prevNode != null)
	            prevNode.next = curr;
	            
	        }
	        return newHead;
	    }

}
