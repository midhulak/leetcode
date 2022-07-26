package com.trees;


public class LCABST {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	
	  
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
         if(p.val < root.val && q.val < root.val){
         return lowestCommonAncestor(root.left , p , q);
            
         }
     
      else if(p.val > root.val && q.val > root.val){
         return lowestCommonAncestor(root.right , p , q);
             
         }
    
  
         return root;
     
    
     
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
