package com.trees;

public class ValidateBST {
	static class TreeNode{
		
		int val;
		TreeNode left ;
		TreeNode right;
		
		
	}
	
	 public static boolean validateBST(TreeNode tree , int minValue , int maxValue){
         
	        if(tree.val < minValue || tree.val >= maxValue)
	            return false;
	        
	    if(tree.left != null && !validateBST(tree.left , minValue , tree.val))
	            return false;
	        
	        if(tree.right != null && !validateBST(tree.right , tree.val , maxValue))
	            return false;
	            
	         return true;
	    }
	    
	    
	     private boolean checkNode(TreeNode node, long min, long max) {
	        if (node == null){
	            return true;
	        }
	        if(node.val > min && node.val < max){
	            return (checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max));
	        } else {
	            return false;
	        }
	    }
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
