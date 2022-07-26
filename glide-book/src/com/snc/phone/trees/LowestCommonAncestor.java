package com.snc.phone.trees;

public class LowestCommonAncestor {
	
  /*
    
    Time Complexity: O(N)O(N), where NN is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.

Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed binary tree could be NN.
*/
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return null;
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        
        if(left != null && right != null)
            return root;
        
        return left != null ? left : right;
        
       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
