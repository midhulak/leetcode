package com.snc.affirm;

public class KthSmallestElementBST {
	
	class TreeNode{
		
		TreeNode left;
		TreeNode right;
		
		int val;
		TreeNode(int val){
			this.val =val;
		}
	}
	
	int count=0;
    int out=0;
    public int kthSmallest(TreeNode root, int k) {
     getKSmallest(root , k);
        return out;
    }
    
    public void getKSmallest(TreeNode root , int k){
        
        if(root.left != null)
         kthSmallest(root.left , k);
        
        
        count++;
        
        if(count == k ){
           out=root.val;
            return;
        }
            
        if(root.right != null)
            kthSmallest(root.right , k);
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
