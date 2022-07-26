package com.snc.facebook.phone;

public class MinDepthBinaryTree {
	
	public int minDepth(TreeNode root) {
        
	    if(root == null)
	        return 0;
	        
	        if(root.left == null && root.right == null)
	            return 1;
	        
	       
	      int left = root.left != null ? 1 + minDepth(root.left) : Integer.MAX_VALUE;
	        
	        
	       int right =root.right != null ? 1+ minDepth(root.right) : Integer.MAX_VALUE;
	        
	        return Math.min(left , right) ;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
