package com.snc.gotanoffer.linkedLists;

public class MergeTwoSortedLinkedLists {
	
	/**
	 * Time complexity : O(n + m)O(n+m)

Because exactly one of l1 and l2 is incremented on each loop iteration, the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. All other work is constant, so the overall complexity is linear.

Space complexity : O(1)O(1)

The iterative approach only allocates a few pointers, so it has a constant overall memory footprint.
	 * @author midhula.kadiyala
	 *
	 */
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
	        ListNode p1Prev= null;
	        ListNode head1=p1;
	        ListNode head2=p2;
	        
	        if(p1 == null)
	            return p2;
	        
	        if(p2 == null)
	            return p1;
	        
	        if(p1 == null && p2==null)
	            return null;
	        
	        while(head1 != null && head2 != null){
	            
	            if(head1.val < head2.val){
	                p1Prev=head1;
	                head1=head1.next;
	            }
	            else{
	                
	                if(p1Prev != null)
	                    p1Prev.next=head2;
	                
	                p1Prev = head2;
	                head2=head2.next;
	                
	                p1Prev.next=head1;
	            }
	            
	        }
	        
	        if(head1 == null)
	            p1Prev.next = head2;
	        
	        return p1.val < p2.val? p1:p2;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
