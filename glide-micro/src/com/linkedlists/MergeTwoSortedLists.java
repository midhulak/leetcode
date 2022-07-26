package com.linkedlists;

public class MergeTwoSortedLists {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sorted_temp = new ListNode(0);
       ListNode current_node = sorted_temp;
       
       while(l1 != null && l2 != null){
           if(l1.val < l2.val){
               current_node.next = l1;
               l1=l1.next;
           }
           else{
               current_node.next = l2;
               l2=l2.next;
           }
           current_node = current_node.next;
       }
       
       if(l1 != null){
           current_node.next = l1;
           l1=l1.next;
       }
       
       if(l2 != null){
           current_node.next = l2;
           l2=l2.next;
       }
       
       return sorted_temp.next;
  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
