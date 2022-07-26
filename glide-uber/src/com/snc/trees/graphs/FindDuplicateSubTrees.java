package com.snc.trees.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTrees {
	
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
	
Map<String , Integer> map = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
         dfs(root , map , res);
        
        return res;
        
    }
    
    public String dfs(TreeNode root ,   Map<String , Integer> map , List<TreeNode> res){
        
        if(root == null)
            return "$";
        
        String path = root.val +"," + dfs(root.left , map , res) + "," + dfs(root.right , map , res);
        
        map.put(path , map.getOrDefault(path , 0)+1);
        
        if(map.get(path) == 2)
            res.add(root);
        
        return path;
            
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
