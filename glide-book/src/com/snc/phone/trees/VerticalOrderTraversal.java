package com.snc.phone.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
//	
//	Time Complexity: \mathcal{O}(N)O(N) where NN is the number of nodes in the tree.
//	Following the same analysis in the previous BFS approach, the only difference is that this time we don't need the costy sorting operation (i.e. \mathcal{O}(N \log N)O(NlogN)).
//
//	Space Complexity: \mathcal{O}(N)O(N) where NN is the number of nodes in the tree. The analysis follows the same logic as in the previous BFS approach.
//
//	
	
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
	
	
	  static class Pair{
        TreeNode node;
        int hd;
        
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
       
        
        List<List<Integer>> result = new ArrayList<>();
        
         if(root == null)
             return result;
        
        Queue<Pair> queue = new LinkedList<>();
        
        Pair p = new Pair();
        p.node=root;
        p.hd=0;
        queue.add(p);
        Map<Integer ,  ArrayList<Integer>> treeMap = new TreeMap<>();
        
        while(!queue.isEmpty()){
            
            Pair temp = queue.remove();
            
            TreeNode node=temp.node;
            
            if(treeMap.containsKey(temp.hd)){
                ArrayList<Integer> list = treeMap.get(temp.hd);
                list.add(node.val);
                treeMap.put(temp.hd , list);
             }
            
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
            treeMap.put(temp.hd , list);
            }
            
            if(node.left != null){
                Pair leftP = new Pair();
                leftP.node=node.left;
                leftP.hd = temp.hd-1;
                queue.add(leftP);
            }
                
               if(node.right != null){
                Pair rightP = new Pair();
                rightP.node=node.right;
                rightP.hd = temp.hd+1;
                queue.add(rightP);
            }
                
        }
        
        for(Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()){
            
            result.add(entry.getValue());
        }
        
        return result;
        
    }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
