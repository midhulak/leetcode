package com.snc.phone.trees;

public class ValidateBST {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(){}
		
		TreeNode(int val){
			this.val = val;
		}
		TreeNode(int val, TreeNode left , TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**
    Time complexity : \mathcal{O}(N)O(N) since we visit each node exactly once.
Space complexity : \mathcal{O}(N)O(N) since we keep up to the entire tree.
**/
    public boolean isValidBST(TreeNode root) {
        
        return validate(root , null ,null);
        
    }
    
    public boolean validate(TreeNode root , Integer max , Integer min){
        
        if(root == null)
            return true;
        
        else if( (max != null && root.val >= max) || (min != null && root.val <= min))
            return false;
        
        else 
        {
            return validate(root.left , root.val ,min) && validate(root.right , max, root.val);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
