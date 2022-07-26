
public class BinaryTreePostInorder {
	
	/*
	 * Time complexity : O(N) 
Space complexity :O(N), since we store the entire tree.
	 */
	
	public static  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
		  }
	
	
        //last element is teh root in postorder tarversal so find root element from postorder tarversal 
   //once you get root node find the index of root node and get size of all elements to teh left of root and also teh size of all elements to teh right of root node.
   //repeat this recursive process until you meet the conditon inorderStart > inorderEnd(end of inorder length)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       int len = inorder.length;
       return helper(inorder, postorder, 0, len - 1, 0, len - 1);
    }
   
   private static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)     {
       if (inStart > inEnd) {
           return null;
       }
       //end element of postorder is teh root value
       int rootVal = postorder[postEnd];
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
       root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
       root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postEnd - rightTreeSize, postEnd - 1);
       return root;
   }
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
