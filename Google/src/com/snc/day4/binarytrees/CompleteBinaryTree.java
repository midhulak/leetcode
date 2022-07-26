package com.snc.day4.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class CompleteBinaryTree {
	
	 public boolean isCompleteTree(TreeNode root) {
	        
	        if(root == null)
	            return true;
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        boolean flag=false;
	        
	        while(!queue.isEmpty()){
	                 
	                TreeNode temp = queue.remove();
	                if(temp==null)
	                    flag=true;
	                	//return false;
	                
	                else{
	                    
	                    if(flag)
	                        return false;
	                    
	                    queue.add(temp.left);
	                    queue.add(temp.right);
	                }
	            
	        }
	        
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
