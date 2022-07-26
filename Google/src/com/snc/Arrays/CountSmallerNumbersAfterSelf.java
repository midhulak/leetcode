package com.snc.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
	
	static class TreeNode {
		TreeNode left; 
		TreeNode right;
		int data;
		int count = 1;
		public TreeNode(int data) {
			this.data = data;
		}
	}
	//{5,2,6,1};
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		res.add(0);
		for(int i = nums.length - 2; i >= 0; i--) {
			int count = insertNode(root, nums[i]);
			res.add(count);
		}
		Collections.reverse(res);
		return res;
	}

	public static int insertNode(TreeNode root, int val) {
		int smaller = 0;
        TreeNode temp = new TreeNode(val);
        boolean isConnected = false;
		while(!isConnected) {
			if(temp.data <= root.data) {
				root.count++;
				if(root.left == null) {
					root.left = temp; 
                    isConnected = true;
				} else {
					root = root.left;
				}
			} else {
				smaller += root.count;
                if(root.right == null) {
					root.right = temp; 
                    isConnected = true;
				} else {
					root = root.right;
				}
			}
		}
		return smaller;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {5,2,6,1};
		
		countSmaller(nums);
		
	}



	

}
