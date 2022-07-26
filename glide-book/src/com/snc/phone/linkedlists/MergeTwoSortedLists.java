package com.snc.phone.linkedlists;

public class MergeTwoSortedLists {
	
	/*
	 *  /*
    Time complexity : O(n + m)O(n+m)

Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.

Space complexity : O(1)O(1)

The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
*/
	 
	
	 public class ListNode {
		      int val;
		     ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        
        while(list1 !=null && list2 != null){
            
            if(list1.val < list2.val){
                currentNode.next = list1;
                list1=list1.next;
            }
            else
            {
                currentNode.next = list2;
                list2=list2.next;
            }
            currentNode = currentNode.next;
            
        }
        
        if(list1 != null){
            currentNode.next = list1;
            
        }
        
        if(list2 != null){
            currentNode.next = list2;
            
        }
        
        return head.next;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
