package com.snc.gotanoffer.linkedLists;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * @author midhula.kadiyala
 *
 */

/**
 * Time Complexity: O(N)O(N) since we process each node exactly twice. Once when we are counting the number of nodes in each recursive call, and then once when we are actually reversing the sub-list.
Space Complexity: O(1)O(1).
 * @author midhula.kadiyala
 *
 */

public class ReverseNodesKgroup {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x , ListNode next){
			val = x;
		}
	}
	
	 public ListNode reverseKGroup(ListNode head, int k){
	        
	        ListNode current = head;
	        ListNode root = new ListNode(0 , head);
	        ListNode prev = root;
	        
	        
	        while(current != null){
	            
	            ListNode tail = current;
	            int listIndex=0;
	            //move list until k and if listindex less than k just add it to the result otherwise 
	            //reverse it and add.
	            while(current != null && listIndex < k){
	                 current = current.next;
	                listIndex++;
	            }
	            
	            if(listIndex != k)
	                prev.next = tail;
	              //once current resches the k nodes will reverse it and prev next pointer to reverse result
	            //and new tail will be prev
	            else{
	                prev.next = reverse(tail , k);
	                prev = tail;
	            }
	                    
	            }
	        //root we start with zero so we use root.next as result.
	        return root.next;
	        }
	 
	 public ListNode reverse(ListNode head , int k){
	        
	        ListNode curr = head;
	        ListNode prev = null;
	        
	        while(curr != null && k > 0){
	            ListNode temp = curr.next;
	            curr.next=prev;
	            prev=curr;
	            curr=temp;
	            k--;
	        }
	       
	        return prev;
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
