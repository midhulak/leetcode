package com.snc.gotanoffer.treesgraphs;

/**
 * Time complexity : \mathcal{O}(N)O(N). Let's compute the solution with the help of master theorem T(N) = aT\left(\frac{b}{N}\right) + \Theta(N^d)T(N)=aT( 
N
b
​	
 )+Θ(N 
d
 ). The equation represents dividing the problem up into aa subproblems of size \frac{N}{b} 
b
N
​	
  in \Theta(N^d)Θ(N 
d
 ) time. Here one divides the problem in two subproblemes a = 2, the size of each subproblem (to compute left and right subtree) is a half of initial problem b = 2, and all this happens in a constant time d = 0. That means that \log_b(a) > dlog 
b
​	
 (a)>d and hence we're dealing with case 1 that means \mathcal{O}(N^{\log_b(a)}) = \mathcal{O}(N)O(N 
log 
b
​	
 (a)
 )=O(N) time complexity.

Space complexity : \mathcal{O}(N)O(N), since we store the entire tree.


 * @author midhula.kadiyala
 *
 */

public class ConstructBinarytreeFromPreIN {
	
	class TreeNode{
		
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
}
