package com.snc.day4.binarytrees;

public class BinaryTreeCameras {
	
	static class TreeNode{
		
		TreeNode left;
		TreeNode right;
	}
	
	private int covered=0;
	private int notCovered=1;
	private int hasCamera=2;
	
	private int cameraCount=0;
	
	
	public int minCameraCover(TreeNode root) {
		return postOrder(root) == covered ? ++cameraCount : cameraCount;
	}
	
	
	private int postOrder(TreeNode root) {
		if(root == null)
			return covered;
		
		int left = postOrder(root.left);
		int right = postOrder(root.right);
		
		if(left == notCovered || right == notCovered) {
			cameraCount++;
			return hasCamera;
		}
		
		else if(left == hasCamera || right == hasCamera)
			return covered;
		
		else
			return notCovered;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
