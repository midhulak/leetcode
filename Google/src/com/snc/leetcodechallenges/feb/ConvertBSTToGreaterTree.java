package com.snc.leetcodechallenges.feb;

public class ConvertBSTToGreaterTree {
	
	static class TreeNode {
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
	
	static int sum=0;
	
	public static TreeNode convertBSTGreater(TreeNode root) {
		
		if(root == null)
			return null;
		
		if(root.right != null)
		convertBSTGreater(root.right);
		
		sum+=root.val;
		root.val=sum;
		if(root.left != null)
		convertBSTGreater(root.left);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
