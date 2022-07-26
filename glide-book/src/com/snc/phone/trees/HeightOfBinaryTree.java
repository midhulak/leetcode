package com.snc.phone.trees;

public class HeightOfBinaryTree {
	
	
	public int height(TreeNode node) {
		if(node = null)
			return 0;
		
		
		int left = height(node.left);
		int right = height(node.right);
		int h=0;
		if(left > right)
			 h = 1+left;
		else
			h=1+right;
		
		return h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
