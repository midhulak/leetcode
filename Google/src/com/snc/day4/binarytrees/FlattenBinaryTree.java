package com.snc.day4.binarytrees;


//Given the root of a binary tree, flatten the tree into a "linked list":
//
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.
// 
//
//Example 1:
//
//
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]


public class FlattenBinaryTree {
	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
		
	
	
	 public void flatten(TreeNode root) {
	        
	        if(root == null)
	            return;
	        
	        if(root.left == null && root.right == null)
	            return;
	        
	        if(root.left != null){
	            //take right node to temp variable and 
	            //swap left node to rightnode
	            flatten(root.left);
	            TreeNode temp = root.right;
	            root.right = root.left;
	            root.left = null;
	            
	            //rigth node come to left then go to extreme right
	            TreeNode curr = root.right;
	            
	            while(curr.right != null){
	                curr=curr.right;
	            }
	            
	            curr.right = temp;
	        }
	        flatten(root.right);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
