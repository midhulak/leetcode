package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {
	
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int val){
			this.val = val;
		}
	}
	
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "X";
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        
        return root.val + "," + leftSerialize + "," +rightSerialize;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] arr  = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i< arr.length; i++){
            queue.add(arr[i]);
        }
        
        return deserializeQueue(queue);
    }
    
    public TreeNode deserializeQueue(Queue<String> queue){
        if(queue.size() == 0)
            return null;
        
        String peek = queue.poll();
        
        if(peek.equals("X"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(peek));
        
        root.left = deserializeQueue(queue);
        root.right = deserializeQueue(queue);
        
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
