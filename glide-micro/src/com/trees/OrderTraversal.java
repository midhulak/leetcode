package com.trees;

import java.util.ArrayList;
import java.util.List;

public class OrderTraversal {
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	
	 List<Integer> list = new ArrayList<>();
	    public List<Integer> inorderTraversal(TreeNode root) {
	        
	        inorder(root);
	        return list;
	    }
	    
	    
	    public void inorder(TreeNode root){
	        if(root == null)
	            return ;
	        
	        inorder(root.left);
	        
	        list.add(root.val);
	        
	        inorder(root.right);
	    }
	    
	    public void preorder(TreeNode root) {
	    	if(root == null)
	    		return;
	    	list.add(root.val);
	    	
	    	preorder(root.left);
	    	preorder(root.right);
	    }
	    
	    public void postOrder(TreeNode root) {
	    	if(root == null)
	    		return;
	    	postOrder(root.left);
	    	postOrder(root.right);
	    	list.add(root.val);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
