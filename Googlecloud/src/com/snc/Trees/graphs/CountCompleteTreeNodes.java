package com.snc.Trees.graphs;

public class CountCompleteTreeNodes {
	
//	Time complexity : \mathcal{O}(N)O(N).
//	Space complexity : \mathcal{O}(d) = \mathcal{O}(\log N)O(d)=O(logN) to keep the recursion stack, where d is a tree depth.

	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val =val;
			
		}
	}
	
public int countNodes(TreeNode root) {
        
        if(root == null)
            return 0;
        
    return 1+countNodes(root.left)+countNodes(root.right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
