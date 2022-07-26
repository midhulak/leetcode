package com.snc.day4.binarytrees;

public class MaxAncestorDiff {


	    int res =0;
	    public int maxAncestorDiff(TreeNode root) {
	          dfs(root);
	        return res;
	        
	    }
	    
	    public void dfs(TreeNode root ){
	        if(root == null)
	            return;
	        
	        if(root.left!= null){
	            
	            res = Math.max(res , Math.abs(root.val - getMin(root.left)));
	            res = Math.max(res , Math.abs(root.val - getMax(root.left)));
	        }
	        
	        if(root.right != null){
	            res = Math.max(res , Math.abs(root.val - getMin(root.right)));
	            res = Math.max(res , Math.abs(root.val - getMax(root.right)));
	        }
	        
	        dfs(root.left );
	        dfs(root.right);
	    }
	    
	    
	    public int getMin(TreeNode root){
	        
	        return root == null ? Integer.MAX_VALUE : Math.min(root.val , Math.min(getMin(root.left) , getMin(root.right)));
	    }
	                                                          
	        public int getMax(TreeNode root){
	            return root == null ? Integer.MIN_VALUE : Math.max(root.val , Math.max(getMax(root.left) , getMax(root.right)));
	        }                                                 
	    
	    
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
