package com.snc.Trees.graphs;

public class BinaryTreeMaxPathSum {
	
	/*
	 * Time complexity: \mathcal{O}(N)O(N), where N is number of nodes, since we visit each node not more than 2 times.

Space complexity: \mathcal{O}(H)O(H), where HH is a tree height, to keep the recursion stack. In the average case of balanced tree, the tree height H = \log NH=logN, in the worst case of skewed tree, H = NH=N.
	 */
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }
    
    public int findMaxPathSum(TreeNode root){
        if(root == null)
            return 0;
        
        int left = Math.max(0 , findMaxPathSum(root.left));
        int right = Math.max(0, findMaxPathSum(root.right));
        
        maxSum = Math.max(maxSum , left+right+root.val);
        
        return Math.max(left, right) + root.val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
