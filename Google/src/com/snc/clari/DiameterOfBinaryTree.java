package com.snc.clari;

public class DiameterOfBinaryTree {

	//TC: O(n) Sc: O(n)
	
		// TODO Auto-generated method stub
		
		static class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;
	        TreeNode(int x) { val = x; }
	    }

	    static int ans;

	    public static int diameterOfBinaryTree(TreeNode root) {
	        ans = 1;
	        depth(root);
	        return ans - 1;
	    }

	    public static int depth(TreeNode node) {
	        if (node == null) {
	            return 0;
	        }

	        int L = depth(node.left);
	        int R = depth(node.right);
	        ans = Math.max(ans, L+R+1);
	        return Math.max(L, R) + 1;
	    }

	    public static void main(String[] args) {
	        TreeNode input_1 = new TreeNode(1);
	        input_1.left = new TreeNode(2);
	        input_1.right = new TreeNode(3);
	        input_1.left.left = new TreeNode(4);
	        input_1.left.right= new TreeNode(5);

	        assert diameterOfBinaryTree(input_1) == 3;
	        System.out.println("Explanation: Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].");

	        System.out.println("Passed all test cases");
	    }

	

}
