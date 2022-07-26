package com.snc.onsite.set1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
	
	
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val = val;
		}
		
	}
	   public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        
	        List<TreeNode> list = new ArrayList<>();
	        
	       Set<Integer> set = new HashSet<Integer>();
	        
	        for(int i=0; i<to_delete.length; i++){
	            set.add(to_delete[i]);
	        }
	        
	        removeNodes(root , set , list);
	        
	        if(!set.contains(root.val)){
	            list.add(root);
	        }
	        
	        return list;
	        
	    }
	    
	    
	    public TreeNode removeNodes(TreeNode root , Set<Integer> to_delete , List<TreeNode> list){
	        
	        if(root == null)
	            return null;
	        
	        root.left = removeNodes(root.left , to_delete , list);
	        root.right = removeNodes(root.right , to_delete , list);
	        
	        if(to_delete.contains(root.val)){
	            if(root.left != null)
	            list.add(root.left);
	            
	            if(root.right != null)
	                list.add(root.right);
	            
	            return null;
	                
	        }
	        
	        return root;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
