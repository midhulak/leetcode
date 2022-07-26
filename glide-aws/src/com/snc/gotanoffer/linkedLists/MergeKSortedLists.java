package com.snc.gotanoffer.linkedLists;

import java.util.PriorityQueue;

/**
 * //add lists to teh queue and poll teh first element form list and iterate to next element from taht listnode and add it to the queue...and it is priority queue it automatically sorts.

 * @author midhula.kadiyala
 *
 */

/**
 * Complexity Analysis

Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are NN nodes in the final linked list.
Space complexity :

O(n)O(n) Creating a new linked list costs O(n)O(n) space.
O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).
 * @author midhula.kadiyala
 *
 */

public class MergeKSortedLists {
	
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	 public ListNode mergeKLists(ListNode[] lists) {
         if (lists==null || lists.length==0) return null;
       
       PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
       
       ListNode dummy = new ListNode(0);
       ListNode tail=dummy;
       
       for (ListNode node:lists)
           if (node!=null)
               queue.add(node);
           
       while (!queue.isEmpty()){
           tail.next=queue.poll();
           tail=tail.next;
           
           if (tail.next!=null)
               queue.add(tail.next);
       }
       return dummy.next;
   }
   
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
