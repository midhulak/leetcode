package com.snc.searching.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
	
	  class TreeNode{
	        int val;
	        int count=1;
	        TreeNode left;
	        TreeNode right;
	        
	        TreeNode(int val){
	            this.val = val;
	        }
	    }
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> result = new ArrayList<>();
	        
	        if(nums == null || nums.length == 0)
	            return result;
	        
	        TreeNode root = new TreeNode(nums[nums.length - 1]);
	        
	        
	        result.add(0);
	        
	        for(int i=nums.length-2; i>=0; i--){
	            int count = insertNode(root , nums[i]);
	            result.add(count);
	        }
	        Collections.reverse(result);
	        return result;
	       
	    }
	    
	    
	    public int insertNode(TreeNode root , int val){
	        int smaller = 0;
	    TreeNode temp = new TreeNode(val);
	        boolean isConnected = false;
	        
	        while(!isConnected){
	        if(temp.val <= root.val){
	           root.count++;
	            
	            if(root.left == null){
	                root.left = temp;
	                isConnected=true;
	            }
	            else{
	                root = root.left;
	            }
	            
	        }
	            
	            else{
	                smaller+=root.count;
	                
	                if(root.right == null){
	                    root.right = temp;
	                    isConnected = true;
	                }
	                else{
	                    root = root.right;
	                }
	                
	            }
	            
	        }
	        return smaller;
	    }
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
