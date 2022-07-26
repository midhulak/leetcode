package com.snc.gotanoffer.linkedLists;

/**
 * Time Complexity: \mathcal{O}(N)O(N) where NN is the size of list. In the worst case, we would iterate through the entire list.

Space Complexity: \mathcal{O}(1)O(1). It is a constant space solution.
 * @author midhula.kadiyala
 *
 */

public class InsertNodeInSortedCircularLinkedList {
	//TC: 
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _next) {
	        val = _val;
	        next = _next;
	    }
	};
	
	public Node insert(Node head , int insertVal) {
		//if head is null just creting new node and insert value into it
		if(head == null) {
			
			Node node = new Node();
			node.val = insertVal;
			node.next=node;
			return node;
		}
		
		//find out last node in the loop if nextnode != head then it might be last node
		Node max = head;
		
		while(max.next != head && max.val <= max.next.val) {
			
			max=max.next;
		}
		//then take the next node of max and put it in min
		Node min = max.next, cur = min;
		
		if(insertVal >= max.val || insertVal <= min.val) {
			Node node = new Node(insertVal , min);
			max.next=node;
		}
		else {
			while(cur.next.val < insertVal) {
				cur = cur.next;
			}
			
			Node node = new Node(insertVal , cur.next);
			cur.next=node;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
