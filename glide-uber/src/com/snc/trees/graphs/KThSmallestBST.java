package com.snc.trees.graphs;

import java.util.PriorityQueue;

public class KThSmallestBST {
	
	static int count=0;
	static int out=0;
	public  class TreeNode {
		TreeNode left;
		TreeNode right;
	    int value;
	        
	    public TreeNode(int value) {
	        this.value = value;
	    }
	}
	
	public int kthSmallest(TreeNode root , int k) {
		inorder(root , k);
		return out;
		
	}

	
	public static void inorder(TreeNode root , int k ) {
		
		if(root.left != null)
			inorder(root.left , k);
		
		count++;
		
		if(count == k)
			out = root.value;
		
		if(root.right != null)
			inorder(root.right , k);
		
	}
	
	
	public static  int findKthLargest(int[] nums , int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		
		for(int i : nums) {
			 q.offer(i);
			
			if(q.size()>k) {
				
				q.poll();
			}
		}
		return q.peek();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
