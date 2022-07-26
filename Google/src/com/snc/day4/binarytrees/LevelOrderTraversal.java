package com.snc.day4.binarytrees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class LevelOrderTraversal {
	
static class TreeNode{
		
		TreeNode right;
		TreeNode left;
		int val;
		TreeNode next;
		TreeNode(int val){
			this.val=val;
		}
	}

static class NodeObj{
	TreeNode node;
	int hd;
	
	NodeObj(TreeNode node , int hd){
		this.node=node;
		this.hd=hd;
	}
}
	

  
  
  
public static void printLevelOrderNull(TreeNode r) {
	  
	  Queue<TreeNode> q = new LinkedList<TreeNode>();
	       q.add(r);
	       q.add(null);
	 while(!q.isEmpty()) {
		  
			 TreeNode temp = q.remove();
			 if(temp != null) {
				 System.out.print(temp.val);
				 if(temp.left != null)
					 q.add(temp.left);
				 
				 if(temp.right != null)
					 q.add(temp.right);
			 }
			 else {
				 if(!q.isEmpty())
					 q.add(null);
				 System.out.println("");
			 }
			
			 
			
		 
		 
	 }
	  
	  
  }

public static void printLeftView(TreeNode r) {
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	 q.add(r);
	 while(!q.isEmpty()) {
		 
		 int size=q.size();
		
		 for(int i=0 ; i<size; i++) {
			 
			 TreeNode temp = q.remove();
			 if(i == 0)
			 System.out.print(temp.val+" ");

			 if(temp.left != null)
				 q.add(temp.left);
			 
			 if(temp.right != null)
				 q.add(temp.right);
		 }
		 
		 System.out.println("");
	 }
	
	
}


public static void printRightView(TreeNode r) {
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	 q.add(r);
	 while(!q.isEmpty()) {
		 
		 int size=q.size();
		
		 for(int i=0 ; i<size; i++) {
			 
			 TreeNode temp = q.remove();
			 if(i == size-1)
			 System.out.print(temp.val+" ");

			 if(temp.left != null)
				 q.add(temp.left);
			 
			 if(temp.right != null)
				 q.add(temp.right);
		 }
		 
		 System.out.println("");
	 }
	
	
}


public static void printTopView(TreeNode r) {
	  if(r == null)
		  return;
	  
	  
	  Queue<NodeObj> q = new LinkedList<NodeObj>();
	  q.add(new NodeObj(r , 0));
	 
	  
	  Map<Integer , TreeNode> map = new TreeMap<Integer , TreeNode>();
	
	 while(!q.isEmpty()) {
		 
//		 int size=q.size();
//		 
//		 for(int i=0 ; i<size; i++) {
			 
			 NodeObj temp = q.remove();
			 
			 if(!map.containsKey(temp.hd)) {
				 map.put(temp.hd, temp.node);
			 }
			 
			 if(temp.node.left != null)
				 q.add(new NodeObj(temp.node.left , temp.hd-1));
			 
			 if(temp.node.right != null)
				 q.add(new NodeObj(temp.node.right , temp.hd+1));
		 }
		 //System.out.println("");
	 //}
	  
	  for(Entry<Integer , TreeNode> entry : map.entrySet()) {
		  System.out.print(entry.getValue().val+",");
	  }
}



public static void printBottomView(TreeNode r) {
	  if(r == null)
		  return;
	  
	  
	  Queue<NodeObj> q = new LinkedList<NodeObj>();
	  q.add(new NodeObj(r , 0));
	 
	  
	  Map<Integer , TreeNode> map = new TreeMap<Integer , TreeNode>();
	
	 while(!q.isEmpty()) {
		 
			 
			 NodeObj temp = q.remove();
			 
				 map.put(temp.hd, temp.node);
			 
			 
			 if(temp.node.left != null)
				 q.add(new NodeObj(temp.node.left , temp.hd-1));
			 
			 if(temp.node.right != null)
				 q.add(new NodeObj(temp.node.right , temp.hd+1));
		
	 }
	  
	  for(Entry<Integer , TreeNode> entry : map.entrySet()) {
		  System.out.print(entry.getValue().val+",");
	  }
}
static Map<Integer , TreeNode> topMap = new TreeMap<Integer , TreeNode>();
static Map<Integer , TreeNode> bottomMap = new TreeMap<Integer , TreeNode>();


public static void printtopViewRecursive(TreeNode r , int c1) {
	
	   if(r == null)
		   return;
	   
	   if(!topMap.containsKey(c1))
		   topMap.put(c1, r);
	   
	   printtopViewRecursive(r.left , c1-1);
	   printtopViewRecursive(r.right , c1+1);
	
}


public static void printbottomViewRecursive(TreeNode r , int c1) {
	
	   if(r == null)
		   return;
	   
	   bottomMap.put(c1, r);
	   
	     printbottomViewRecursive(r.left , c1-1);
	     printbottomViewRecursive(r.right , c1+1);
	
}


public static void printLevelOrder(TreeNode r) {
	Queue<TreeNode> q = new LinkedList<TreeNode>();
	 q.add(r);
	 while(!q.isEmpty()) {
		 
		 int size=q.size();
		
		 for(int i=0 ; i<size; i++) {
			 
			 TreeNode temp = q.remove();
			 if(i == size-1)
			 System.out.print(temp.val+" ");

			 if(temp.left != null)
				 q.add(temp.left);
			 
			 if(temp.right != null)
				 q.add(temp.right);
		 }
		 
		 System.out.println("");
	 }
	
	
}



public static void printLevelOrderNullConnect(TreeNode r) {
	  
	  Queue<TreeNode> q = new LinkedList<TreeNode>();
	       q.add(r);
	       q.add(null);
	       TreeNode temp=null;
	 while(!q.isEmpty()) {
		  
		       TreeNode prev = temp;
			  temp = q.remove();
			 
			
			 
			 if(temp != null) {
				 if(prev != null)
				  prev.next = temp;
				 System.out.print(temp.val);
				 if(temp.left != null)
					 q.add(temp.left);
				 
				 if(temp.right != null)
					 q.add(temp.right);
			 }
			 else {
				 
				
				 if(!q.isEmpty())
					 q.add(null);
				 System.out.println("");
			 }
			
			 
			
		 
		 
	 }
	  
	  
}



public static void printLevelOrderconnectNext(TreeNode r) {
	  
	  Queue<TreeNode> q = new LinkedList<TreeNode>();
	  TreeNode temp=null;
	  q.add(r);
	      
	 while(!q.isEmpty()) {
		  
		 int n= q.size();
		 
		 for(int i=0 ; i<n ; i++) {
			 
			 TreeNode prev = temp;
			 
			 temp=q.poll();
			 
			 if(i>0)
				 prev.next=new TreeNode(temp.val);
			// System.out.println(r.next.val);
			 if(temp.left != null)
				 q.add(temp.left);
			 if(temp.right != null)
			 q.add(temp.right);
			 
			 
		 }
			//temp.next=null;
	 }
	  
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(3);
		t.right = new TreeNode(8);
		t.left.right = new TreeNode(4);
		t.right.left= new TreeNode(6);
		t.right.left.right= new TreeNode(7);
		t.right.right= new TreeNode(20);
		
		printbottomViewRecursive(t  , 0);
		for(Entry<Integer , TreeNode> entry : bottomMap.entrySet()) {
			  System.out.print(entry.getValue().val+"==>");
		  }
		
//		System.out.println("It shud print 8==>" +t.left.next.val); //8
//		System.out.println("It shud print 6==>" +t.left.right.next.val); //6
//		System.out.println("It shud print 20==>" +t.right.left.next.val); //20
//	
	}

}
