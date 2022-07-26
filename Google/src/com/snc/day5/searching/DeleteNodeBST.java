package com.snc.day5.searching;



public class DeleteNodeBST {
	
	static class TreeNode{
		TreeNode right;
		TreeNode left;
		int data;
		TreeNode(int val){
			this.data=val;
		}
	}
	
	public static TreeNode deleteNode(TreeNode root , int val) {
		
		if(root == null)
			  return null;
		
		if(val < root.data)
			root.left = deleteNode(root.left , val);
		
		else if(val > root.data)
			root.right = deleteNode(root.right , val);
		
		else {
			
			if(root.left == null)
				return root.right; 
			
			else if(root.right == null)
				return root.left;
			
			root.data = minValue(root.right);
			System.out.println(root.data);
			root.right = deleteNode(root.right , root.data);
		}
		return root;
		
	}
	
	
	public static TreeNode insert(TreeNode root , int val) {
		
		if(root == null)
			return new TreeNode(val);
		
		if(val < root.data)
			root.left = insert(root.left , val);
		
		if(val > root.data)
			root.right = insert(root.right , val);
		
		
		
		return root;
	}
	
	public static int minValue(TreeNode root) {
		
		int min = root.data;
		
		while(root.left != null) {
			
			min=root.left.data;
			root = root.left;
		}
		
		return min;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(3);
		t.left.left = new TreeNode(2);
		t.right = new TreeNode(8);
		t.left.right = new TreeNode(4);
		t.right.left= new TreeNode(6);
		t.right.left.left= new TreeNode(5);
		t.right.left.right= new TreeNode(9);
		t.right.right= new TreeNode(20);
		t.right.right.left= new TreeNode(15);
		t.right.right.right= new TreeNode(25);
		
		
		
		TreeNode root = insert(t , 7);
	}

}
