package com.snc.LinkedLists;

public class RemoveNthFromEnd {
	
	class ListNode{
		ListNode next;
		int val;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int k) {
        
	       ListNode returnNode = new ListNode(0);
	        returnNode.next = head;
	        
	        ListNode first = returnNode; //move first node to k pointers 
	        ListNode second = returnNode;
	        
	        //once first node reach till to the end of teh list then second pointer will be 1 step before the last to kth node of the list.
	        for(int i=0; i<k+1; i++){
	            
	            first = first.next;
	        }
	        
	        while(first != null){
	            first = first.next;
	            second = second.next;
	        }
	        
	        second.next = second.next.next;
	        
	        return returnNode.next;
	        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
