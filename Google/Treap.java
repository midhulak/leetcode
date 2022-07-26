package Google;

import java.util.Arrays;

public class Treap {
	/*
     Since we need to maintain the max heap property, which means the second element will be always highest to lowest
     in each level and the first element follow the BST property.
    
     Sort the data based on second element, and then keep inserting based on first element following bst property
    Time : O(nlogn)
     */
    public static TreapNode buildTreapMaxHeap(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums, ((o1, o2) -> o2[1] - o1[1]));

        final TreapNode root = new TreapNode(nums[0][0], nums[0][1]);

        for (int i = 1; i < nums.length; i++)
            insert(nums[i], root);

        return root;
    }

    private static TreapNode insert(int[] e, final TreapNode root) {

        if (root == null)
            return new TreapNode(e[0], e[1]);

        if (e[0] < root.bstVal)
            root.left = insert(e, root.left);
        else
            root.right = insert(e, root.right);

        return root;

    }

        public static void main(String[] args) {
        	int[][]arr = {{1, 4}, {8, 5}, {3, 6}, {10, -1}, {4, 7}};           
            System.out.println(buildTreapMaxHeap(arr));
        }
    
    
    static class TreapNode {
    	int bstVal;
    	int heapVal;
    	TreapNode left;
    	TreapNode right;
    	public TreapNode(int b, int h) {
    		bstVal = b;
    		heapVal = h;
    	}
    }
}
