package com.trees;

public class CountGoodNodes {
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}

	int count=0;
    public int goodNodes(TreeNode root) {
        
        
        helper(root , root.val);
        return count;
    }
    
    public void helper(TreeNode root , int val){
        if(root == null)
            return;
        
        if(root.val >= val){
            val=root.val;
            count++;
        }
            
        
        helper(root.left , val);
        helper(root.right , val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
