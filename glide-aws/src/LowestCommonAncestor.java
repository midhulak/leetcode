
/*
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
 */

public class LowestCommonAncestor {

	 static class TreeNode{
		 
		 TreeNode left;
		 TreeNode right;
		 int val;
		 
		 TreeNode(int val){
		    val=val;	 
		 }
	 }
	   public TreeNode lowestCommonAncestor(TreeNode tree, TreeNode n1, TreeNode n2) {
	       
	       return lca(tree, n1.val , n2.val);
	       
	   }

	    public static TreeNode lca(TreeNode node , int n1 , int n2){
	        if(node == null)
	            return null;
	        
	        if(node.val == n1 || node.val == n2)
	            return node;
	        
	        TreeNode left_lca = lca(node.left , n1 , n2);
	        TreeNode right_lca = lca(node.right , n1 ,n2);
	        
	        if (left_lca != null && right_lca != null) {
	               return node;
	           }
	        
	         return (left_lca != null) ? left_lca : right_lca;
	        
	    }
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
