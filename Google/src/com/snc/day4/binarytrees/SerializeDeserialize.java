package com.snc.day4.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import com.snc.day4.binarytrees.FindLevelOfNodeinTree.TreeNode;

public class SerializeDeserialize {
	
	static class Node{
		
		int val;
		Node left;
		Node right;
		
		Node(int data){
			this.val = data;
		}
		
	}
	
	
	public String SerializePre(Node root) {
		
		if(root == null)
			return "X";
		
		String leftSerialize = SerializePre(root.left);
		String rightSerialize = SerializePre(root.right);
		
		
		return root.val + "," +leftSerialize +","+rightSerialize;
		
		
	}
	
	public TreeNode deserialize(String data) {
		
		String[] arr = data.split(",");
		
		Queue<String> queue = new LinkedList<>();
		
		for(int i=0 ; i<arr.length; i++){
			
			queue.add(arr[i]);
			
		}
				
		return deserializeQueue(queue);
		
	}
	
	public TreeNode deserializeQueue(Queue<String> queue) {
		
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
	
	
	
	public static Node construct(char[] str , int i) {
		System.out.println("passed i value is="+i);
		if(i > str.length)
			return null;
		if(str[i] == '$' )
			return null;
		
		System.out.println("i is="+i);
		Node root = new Node(str[i]);
		
		root.left = construct(str , 2*i+1);
		System.out.println("after retrun root.left i is="+i);
		root.right = construct(str , 2*i+2);
		System.out.println("after retrun root.right i is="+i);
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] str = {'A','B','C','$','D','E','G','$','$','H','$','$','$','$','$'};
		
		construct(str , 0);

	}

}
