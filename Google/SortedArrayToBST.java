package Google;

import Google.ShortestPathRootToLeaf.TreeNode;

public class SortedArrayToBST {
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
	public static TreeNode converstArrayToBST(int[]arr) {
		if(arr == null) {
			return null;
		}
		return binarySearch(arr, 0, arr.length - 1);
	}
	public static TreeNode binarySearch(int[]arr, int low, int high) {
		if(low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = binarySearch(arr, low, mid - 1);
		root.right = binarySearch(arr, mid + 1, high);
		System.out.println(root);
		return root;
	}
	public static void main(String[]args) {
		int[] arr = {-10, -3, 0, 5, 9};
		System.out.println(converstArrayToBST(arr));
	}
}
