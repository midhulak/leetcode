package com.snc.phone.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	
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
	
	  /**
	   * https://leetcode.com/problems/binary-tree-right-side-view/
    The problem is to return a list of last elements from all levels, so it's the way more natural to implement BFS here.

Time complexity is the same \mathcal{O}(N)O(N) both for DFS and BFS since one has to visit all nodes.

Space complexity is \mathcal{O}(H)O(H) for DFS and
\mathcal{O}(D)O(D) for BFS, where HH is a tree height, and DD is a tree diameter. They both result in \mathcal{O}(N)O(N) space in the worst-case scenarios: skewed tree for DFS and complete tree for BFS.

**/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size= queue.size();
            
            for(int i=0; i<size; i++){
                
                TreeNode temp = queue.remove();
                
                if(i == size-1)
                    result.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                
                if(temp.right != null)
                    queue.add(temp.right);
                
                
            }
            
            
        }
        
        
        return result;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
