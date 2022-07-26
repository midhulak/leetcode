package com.snc.phone.trees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
	
	/**
	   Time complexity : we visit each node exactly once, thus the time complexity is \mathcal{O}(N)O(N), where NN is the number of nodes.
	Space complexity : \mathcal{O}(N)O(N). Here we use the space for a stack call and for a paths list to store the answer. paths contains as many elements as leafs in the tree and hence couldn't be larger than \log NlogN for the trees containing more than one element. Hence the space complexity is determined by a stack call. In the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be \mathcal{O}(N)O(N). But in the best case (the tree is balanced), the height of the tree would be \log(N)log(N). Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)).


	*/
	
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
	    
	    
	    public List<String> binaryTreePaths(TreeNode root) {
	         LinkedList<String> result = new LinkedList<>();
	         dfs(root ,  result , "");
	        return result;
	    }
	        
	    
	    public void dfs(TreeNode root , LinkedList<String> result , String sb){
	       if(root != null){
	           sb+=(Integer.toString(root.val));
	           
	        if( root.left == null && root.right == null)
	            result.add(sb);
	        else{
	            sb+="->";
	            dfs(root.left , result , sb);
	            dfs(root.right, result , sb);
	                        }
	           
	        }
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
