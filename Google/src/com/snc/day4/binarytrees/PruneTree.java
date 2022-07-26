package com.snc.day4.binarytrees;

public class PruneTree {
	
//	Example 3:
//
//
//		Input: root = [1,1,0,1,1,0,1,0]
//		Output: [1,1,0,1,1,null,1]
	
	//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3824/
	
public TreeNode pruneTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if(root.val == 0 && root.left == null && root.right == null)
            return null;
        else
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
