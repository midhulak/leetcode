package com.linkedlists;

public class IntersectionLinkedLists {
	
	static class ListNode{
		ListNode next;
		int val;
	}
	
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
       /* move both pointers at same time and shorter list will complete first then shorter list atatch with longer list and by the time 
       longer  list complete its iteration teh longer will be shorter and new shorter list already iterated diff amount and both will be the same.*/
        while(nodeA != nodeB){
            
            if(nodeA == null)
                nodeA=headB;
            else
                nodeA = nodeA.next;
            
            if(nodeB == null)
                nodeB=headA;
            else
                nodeB = nodeB.next;
        }
        
        return nodeA;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
