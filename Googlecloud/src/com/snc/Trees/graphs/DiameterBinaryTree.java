package com.snc.Trees.graphs;

public class DiameterBinaryTree {
	
	 /**
    Let NN be the number of nodes in the tree.

Time complexity: O(N)O(N). This is because in our recursion function longestPath, we only enter and exit from each node once. We know this because each node is entered from its parent, and in a tree, nodes only have one parent.

Space complexity: O(N)O(N). The space complexity depends on the size of our implicit call stack during our DFS, which relates to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N)O(N). If the tree is balanced, it'd be O(\log N)O(logN).
    
    
    */
    static int ans;
    
    static class TreeNode{
    	TreeNode left;
    	TreeNode right;
    	int val;
    	
    	TreeNode(int val){
    		this.val = val;
    	}
    }
    public int diameterOfBinaryTree(TreeNode root) {
        ans=0;
        dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode node){
        if(node == null)
            return 0;
        
         // recursively find the longest path in
        // both left child and right child
        int left = dfs(node.left);
        int right = dfs(node.right);
        //  // update the diameter if left_path plus right_path is larger
         ans = Math.max(ans , left+right);
        //   // return the longest one between left_path and right_path;
        // remember to add 1 for the path connecting the node and its parent
        
        return Math.max(left , right) + 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
