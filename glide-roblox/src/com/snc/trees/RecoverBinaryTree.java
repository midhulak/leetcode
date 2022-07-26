package com.snc.trees;


/**
 * 
 * @author midhula.kadiyala
 * first need to see inorder traversal is sorted so convert teh tree into inorder traversal and then need to check whewre is descrepencies if more than 2 airs 
 * 
 * in 1st pair highest value will be swapped to secons pair second value (because highest valuesa in bst always at teh right side so need to swap
 * 
 * and here instea dof converting tree to inorder while traversing taking two nodes whcih has pair of descrepencies if only 1 descrepency we are just swapping those..
 * 
 * if there are more than 2 pairs of descrepency then first value of frist pair swapping with second value of second pair.
 *
 */
public class RecoverBinaryTree {
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(){
			
		}
TreeNode(int val){
			this.val = val;
		}
TreeNode(int val , TreeNode left , TreeNode right){
	this.val = val;
	this.left=left;
	this.right = right;
}
		
	}
	TreeNode head = null;
	TreeNode tail = null;
	TreeNode prev = null;
	
	public void RecoverTree(TreeNode root) {
		
		if(root == null)
			return;
		
		inorder(root);
		
	}

	
	public void inorder(TreeNode root) {
		
		if(root == null)
			return;
		
		inorder(root.left);
		
		if(prev != null)
			if(prev.val > root.val) {
				
				if(head == null)
					head = prev;
				tail = root;
			}
		
		prev=root;
		inorder(root.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
