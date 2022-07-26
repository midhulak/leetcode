package com.snc.day4.binarytrees;

public class MergeTree {
	
	// Java program to Merge Two Binary Trees

	/* A binary tree node has data, pointer to left child
	and a pointer to right child */
	static class Node
	{
		int data;
		Node left, right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			
		}
	}
		/* Helper method that allocates a new node with the
		given data and NULL left and right pointers. */
		static Node newNode(int data)
		{
			return new Node(data, null, null);
		}
		
		/* Given a binary tree, print its nodes in inorder*/
		static void inorder(Node node)
		{
			if (node == null)
				return;
		
			/* first recur on left child */
			inorder(node.left);
		
			/* then print the data of node */
			System.out.printf("%d ", node.data);
		
			/* now recur on right child */
			inorder(node.right);
		}
		
		static void inorder(TreeNode node)
		{
			if (node == null)
				return;
		
			/* first recur on left child */
			inorder(node.left);
		
			/* then print the data of node */
			System.out.printf("%d ", node.data);
		
			/* now recur on right child */
			inorder(node.right);
		}
		
		static TreeNode root = null;
		static TreeNode MergeMyTrees(Node t1 , Node t2) {
			int sum=0;
			if(t1 != null)
				sum+=t1.data;
			if(t2 != null)
				sum+=t2.data;
			
			if(t1==null && t2==null)
				return root;
			
			TreeNode root =new TreeNode(sum);
			
			root.left = MergeMyTrees(t1 != null ? t1.left : null , t2!=null ? t2.left : null);
			root.right = MergeMyTrees(t1 != null ? t1.right : null , t2!=null ? t2.right : null);
			
				return root;
			
		}
		
		/* Method to merge given two binary trees*/
		static Node MergeTrees(Node t1, Node t2)
		{
			if (t1 == null)
				return t2;
			if (t2 == null)
				return t1;
			t1.data += t2.data;
			t1.left = MergeTrees(t1.left, t2.left);
			t1.right = MergeTrees(t1.right, t2.right);
			return t1;
		}
		
		// Driver method
		public static void main(String[] args)
		{
			/* Let us construct the first Binary Tree
					1
				/ \
				2	 3
				/ \	 \
				4 5	 6
			*/
		
			Node root1 = newNode(1);
			root1.left = newNode(2);
			root1.right = newNode(3);
			root1.left.left = newNode(4);
			root1.left.right = newNode(5);
			root1.right.right = newNode(6);
		
			/* Let us construct the second Binary Tree
					4
				/ \
				1	 7
				/	 / \
			3	 2 6 */
			Node root2 = newNode(4);
			root2.left = newNode(1);
			root2.right = newNode(7);
			root2.left.left = newNode(3);
			root2.right.left = newNode(2);
			root2.right.right = newNode(6);
		
			//Node root3 = MergeTrees(root1, root2);
			TreeNode root3 = MergeMyTrees(root1, root2);
			System.out.printf("The Merged Binary Tree is>>:\n");
			inorder(root3);
		}
	}

	


