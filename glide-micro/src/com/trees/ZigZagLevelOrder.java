package com.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.trees.LevelOrderTraversal.TreeNode;

public class ZigZagLevelOrder {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	 
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	 if(root == null) return new ArrayList();
     List<List<Integer>> result = new ArrayList();
     Queue<TreeNode> q = new LinkedList();
     q.add(root);
     boolean reverseLevel = false;

     while(!q.isEmpty()) {
         int size = q.size();
         List<Integer> level = new ArrayList();
         for(int i=0 ; i<size; i++) {
             root = q.remove();
             level.add(root.val);
             
             if(root.left != null) q.add(root.left);
             if(root.right != null) q.add(root.right);
         }
         if(reverseLevel) Collections.reverse(level);
         result.add(level);
         reverseLevel = !reverseLevel;
     }

     return result;
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
