package com.snc.day4.binarytrees;

public class LongestConsequtive {
	
static class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	 TreeNode(int val){
		this.val = val; 
	 }
	
}



//private static int maxLength = 0;
//public static int longestConsecutive(TreeNode root) {
//    dfs(root, null, 0);
//    return maxLength;
//}

//private static void dfs(TreeNode p, TreeNode parent, int length) {
//    if (p == null) return;
//    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
//    maxLength = Math.max(maxLength, length);
//    dfs(p.left, p, length);
//    dfs(p.right, p, length);
//}

//public static int longestConsecutive(TreeNode root) {
//    return dfs(root, null, 0);
//}

private static int dfs(TreeNode p, TreeNode parent, int length) {
    if (p == null) return length;
    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
    return Math.max(length, Math.max(dfs(p.left, p, length),
                                     dfs(p.right, p, length)));
}
	
	private static int maxLength = 0;
	public static int longestConsecutive(TreeNode root) {
	    dfs(root);
	    return maxLength;
	}

	private static int dfs(TreeNode p) {
	    if (p == null) return 0;
	   
	    int L = dfs(p.left) + 1;
	    int R = dfs(p.right) + 1;
	    if (p.left != null && p.val + 1 != p.left.val) {
	        L = 1;
	    }
	    if (p.right != null && p.val + 1 != p.right.val) {
	        R = 1;
	    }
	    int length = Math.max(L, R);
	    maxLength = Math.max(maxLength, length);
	    return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(4);
		node.right.right.right = new TreeNode(5);
		
		node.right.left = new TreeNode(2);
		
		System.out.println(longestConsecutive(node));
	}

}
