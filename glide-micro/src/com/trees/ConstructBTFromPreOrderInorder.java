package com.trees;

import com.trees.LCABST.TreeNode;

public class ConstructBTFromPreOrderInorder {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			
		}
	}
	
	
	 //first element is teh root in preorder tarversal so find root element from preorder tarversal 
    //once you get root node and after that all elemenst are left and then followed by right in preorder.
    //after root element check teh next element in preorder and see that index in post order in post order till taht index are left elements and rest are right elements
    //calculate teh start and end positions based on above 2 points and 1 base check we are finding next index of root element so need to handle teh base case if prestart exactly equals to preend need tt stop by returning root.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        return helper(preorder, inorder, 0, len - 1, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd)     {
        if (inStart > inEnd) {
            return null;
        }
        //end element of postorder is teh root value
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inStart;
        //find the root value index in inorder 
        for (rootIndex = inStart; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        //seperate the left and right elemnets based on root index in inoprder array
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;
        
        //by using teh size calculate teh start and end pointers of inorder and postorder array.
        root.left = helper(preorder, inorder, inStart, rootIndex - 1, preStart+1, preStart + leftTreeSize);
        root.right = helper(preorder, inorder, rootIndex + 1, inEnd, preEnd - (rightTreeSize-1), preEnd);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
