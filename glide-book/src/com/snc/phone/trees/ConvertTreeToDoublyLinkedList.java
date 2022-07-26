package com.snc.phone.trees;


/**
 * /TC: O(N) SC: O(N)
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * @author midhula.kadiyala
 *
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class ConvertTreeToDoublyLinkedList {
	
	 Node headLinkedList;
	    Node prev;
	    //prev node points to left and next node points to right node
	    
	    public Node treeToDoublyList(Node root){
	        if(root == null)
	            return null;
	        getInorder(root);
	        
	        return headLinkedList;
	    }
	    public void getInorder(Node node) {
	        //calculate inorder traversal of binary tree and then convert into double linked list which is left root and right and also this is in sorted order..
	        if(node == null)
	            return ;
	        
	        getInorder(node.left);
	        
	       if(prev == null){
	           headLinkedList = node;
	           prev = node;
	           
	       }
	        else{
	           node.left = prev;
	            prev.right=node;
	            prev=node;
	            
	        }
	        
	        getInorder(node.right);
	    }    
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
