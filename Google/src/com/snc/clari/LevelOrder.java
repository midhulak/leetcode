package com.snc.clari;

import java.io.*;
import java.util.*;


public class LevelOrder {
	
	 static class TreeNode{
	    
	    TreeNode left;
	    TreeNode right;
	    int val;
	    
	    TreeNode(int val){
	    	this.val = val;
	    }
	    
	  }
	  
	  
	  public static  void levelOrder(TreeNode root){
	    
	   if(root == null)
	       return;
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    
	    queue.add(root);
	    
	    int forwardCarry=0;
	    
	    while(!queue.isEmpty()){
	      
	     
	      int size = queue.size();   // [ ,  , REp1 , REp2]   sum=400
	                                             // sum =250+200.  carry =200
	      int sum=0;
	       
	     int  carry=forwardCarry;
	      
	      for(int i=0; i<size; i++){
	        
	        TreeNode node = queue.remove();
	        sum+=node.val;  
	        
	        if(node.left == null && node.right == null){
	          
	          forwardCarry+=node.val;
	        }
	         
	        if(node.left != null){
	        
	          queue.add(node.left);
	        }
	        
	         if(node.right != null){
	          
	          queue.add(node.right);
	        }
	        
	      }
	      
	      System.out.print(sum+carry+" ");
	     
	    }

	      
	    
	  }
	  
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode node = new TreeNode(450);
		node.left = new TreeNode(250);
		node.right = new TreeNode(200);
		
		node.left.left = new TreeNode(150);
		node.left.right = new TreeNode(150);
		node.left.left.left = new TreeNode(20);
		node.left.left.right = new TreeNode(15);
		
		
		levelOrder(node);
	}

}
