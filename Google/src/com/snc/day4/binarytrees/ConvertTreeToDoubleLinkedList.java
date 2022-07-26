package com.snc.day4.binarytrees;

public class ConvertTreeToDoubleLinkedList {
	
	static class TreeNode{
		
		TreeNode prev;
		TreeNode left;
		TreeNode right;
	}

	//inorder and added to list left right and root
	public void convertList(TreeNode root , TreeNode head) {
		
		if(root == null)
			return;
		
		 TreeNode prev = null;
		 
		 convertList(root.left , head);
		 
		 if(prev == null) {
			 head=root;
		 }
		 else {
			root.left=prev;
			prev.right=root;
		 }
		 prev = head;
		 
		 convertList(root.right , head);
		
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
