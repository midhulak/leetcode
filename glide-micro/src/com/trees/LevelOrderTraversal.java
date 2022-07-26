package com.trees;

import java.util.ArrayList;

import com.trees.OrderTraversal.TreeNode;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if(root == null)
	            return result;
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.add(root);
	        
	        
	        
	        while(!queue.isEmpty()){
	            
	            int size = queue.size();
	             List<Integer> res = new ArrayList<Integer>();
	            for(int i=0 ; i<size; i++){
	               
	                TreeNode curr = queue.remove();
	                
	                res.add(curr.val);
	                
	                if(curr.left != null)
	                    queue.add(curr.left);
	                
	                   if(curr.right != null)
	                    queue.add(curr.right);
	                
	                
	                
	            }
	            
	            result.add(res);
	            
	        }
	        
	        
	        return result;
	        
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
