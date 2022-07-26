package com.trees;

public class ConstructMaxBinaryTree {
	static class TreeNode {
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
	
	public TreeNode constructMaximumBinaryTree(int[] nums ) {
        
	     return  helper(nums , 0 , nums.length-1);
	        
	        
	    }
	    
	    
	    public TreeNode helper(int[] nums , int start , int end){
	       
	        if(start > end)
	            return null;
	        
	        if(start == end)
	            return new TreeNode(nums[end]);
	        
	         int index = findMaxIndex(nums , start , end);
	        
	           
	        TreeNode t = new TreeNode(nums[index]);
	        
	        t.left = helper(nums , start , index-1);
	         t.right= helper(nums , index+1, end);
	        
	        return t;
	    }
	    
	    
	    public int findMaxIndex(int[] nums, int start , int end){
	        
	        int max = 0;
	        int index=-1;
	        
	        for(int i=start; i<=end ; i++){
	            if(max < nums[i]){
	                max=nums[i];
	                index=i;
	            }
	        }
	        
	        return index;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
