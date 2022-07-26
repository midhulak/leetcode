package com.snc.day4.binarytrees;

public class PrintAncestorOfNode {
	
	static class TreeNode{
		
		TreeNode right;
		TreeNode left;
		int val;
		TreeNode(int val){
			this.val=val;
		}
	}
	
	public static boolean printAncestorsOfNode(TreeNode r , int v) {
		
		if(r == null)
			return false;
		
		if(r.val == v)
			return true;
		
		if( printAncestorsOfNode(r.left , v) || printAncestorsOfNode(r.right , v) ) {
			
			System.out.println(r.val);
			return true;
		}
		
		return false;
	}
	
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	        return lca(root , p.val , q.val);
	    }
	    
	    public static TreeNode lca(TreeNode node , int n1 , int n2){
	        if(node == null)
	            return null;
	        
	        if(node.val == n1 || node.val == n2)
	            return node;
	        
	        TreeNode left_lca = lca(node.left , n1 , n2);
	        TreeNode right_lca = lca(node.right , n1 , n2);
	        
	        //if both childs are returning something we can find that is common ansector 
	        if(left_lca != null && right_lca != null){
	            return node;
	        }
	        //we always return nonnull node.
	        return left_lca != null ? left_lca : right_lca;
	    }
	
	    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
	        
	        if(p.val < root.val && q.val < root.val)
	            return lowestCommonAncestor(root.left , p , q);
	         
	          else if(p.val > root.val && q.val > root.val)
	            return lowestCommonAncestor(root.right , p , q);
	            
	            else
	                return root;
	            
	      }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(3);
		t.right = new TreeNode(8);
		t.left.left = new TreeNode(4);
		t.right.left= new TreeNode(6);
		t.right.left.right= new TreeNode(7);
		t.right.right= new TreeNode(20);
		
		printAncestorsOfNode(t , 4);

	}

}
