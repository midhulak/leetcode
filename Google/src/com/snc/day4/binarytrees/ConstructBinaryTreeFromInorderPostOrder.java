package com.snc.day4.binarytrees;

public class ConstructBinaryTreeFromInorderPostOrder {
	
	
	
	 public TreeNode buildTreePreOrder(int[] preorder, int[] inorder) {
         return buildTreePreOrder(preorder, inorder, 0, inorder.length - 1, 0);
     }

     private TreeNode buildTreePreOrder(int[] preorder, int[] inorder, int start, int end, int index) {
         if (start > end) return null;
         TreeNode root = new TreeNode(preorder[index]);

         int inIndex = start;
         while (preorder[index] != inorder[inIndex]) inIndex++;

         root.left = buildTreePreOrder(preorder, inorder, start, inIndex - 1, index + 1);
         root.right = buildTreePreOrder(preorder, inorder, inIndex + 1, end, index + inIndex - start + 1);

         return root;
     }
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return helper(inorder, postorder, 0, len - 1, 0, len - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)     {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inStart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;
        
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postEnd - rightTreeSize, postEnd - 1);
        return root;
    }
    
    

    public TreeNode bstFromPreorder(int[] preorder) {
       return helper(preorder, 0, preorder.length);
       
   }
   
   public TreeNode helper(int[] preorder, int rootindex, int right)
   {        
       if(rootindex >= right) return null;
       
       int value = preorder[rootindex];
       TreeNode root = new TreeNode(value);
       
       int i = rootindex+1;
	    while(i <= preorder.length-1 && preorder[i] < value)
       {
           i++;
       }
       root.left = helper(preorder, rootindex+1, i);
       root.right = helper(preorder,i, right);
       
       return root;        
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
