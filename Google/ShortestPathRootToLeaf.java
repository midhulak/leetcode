package Google;

public class ShortestPathRootToLeaf {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	public static int shortestPath(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.min(shortestPath(root.left), shortestPath(root.right));
	}
	public static void main(String[]args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(13);
		root.right.left = new TreeNode(12);
		root.right.left.right = new TreeNode(5);
		System.out.println(shortestPath(root));
	}
}
