package com.snc.phone.trees;

public class FlattenBinaryTree {
	
	public class TreeNode{
		
		TreeNode left;
		TreeNode right;
		TreeNode val;
		
		TreeNode(int val){
			this.val = val;
		}
	}
    /**
    //TC :O(n)
	//SC : O(n)
	
//	1.Take temp_left, temp_right to store the left and right
//	2.Make node->left as null
//	3.flatten left(temp-left) and right temp_right tree recursively
//	4.attach the left part to right side
//	5.Traverse till the bottom most node in the attached part and attach the right it
*/
    public void flattenRecursive(TreeNode root){
        
        if(root == null)
            return;
        
    TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;
        
        root.left = null;
        
        flattenRecursive(tempLeft);
        flattenRecursive(tempRight);
        
        root.right = tempLeft;
        
        TreeNode curr = root;
        
        while(curr.right != null){
            curr = curr.right;
        }
        
        curr.right = tempRight;
    }
    
    
    //Tc: O(n)
    //SC :O(1);
    
    //start from root
    //if left is not null go to its left. and then traverse to the rightmost child of node
    //connect its right to the right of root marking the route
    //Take the left and put it to the right and make the  left null
    //move to the next node-rott-right
    //Repeat the process
    /*
    check left
    If not null, go to its rightmost child
    connect it to root->right
    connect the whole left  to root->right
    make rrot ->left to null
    update root to root ->right
    
    */
    
    public void flattenIterative (TreeNode root){
        if(root == null)
            return;
        
        while(root != null){
            if(root.left != null){
                TreeNode left = root.left;
            TreeNode curr = root.left;
            
            while(curr.right != null){
                curr=curr.right;
            }
            root.left = null;
            curr.right = root.right;
            root.right = left;
        }
        root=root.right;
    }
        
    
}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
