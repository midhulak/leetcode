package com.snc.trees.graphs;
/*https://leetcode.com/problems/invert-binary-tree/ */
public class InvertTree {
	
	
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	
	  //DFS
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
            
    TreeNode left = invertTree(root.left);
        TreeNode right  = invertTree(root.right);
        
      swap(root);
        return root;
    }
    
    
 
    public void swap(TreeNode root){
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
    //BFS
  public TreeNode invertTree1(TreeNode tree){
      if(tree == null)
          return null;
      
      ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
      queue.addLast(tree);
      
      while(queue.size() > 0){
          
          TreeNode curr = queue.pollFirst();
          swap(curr);
          
          if(curr.left != null)
              queue.addLast(curr.left);
          
          if(curr.right != null)
              queue.addLast(curr.right);
      }
      
      return tree;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
