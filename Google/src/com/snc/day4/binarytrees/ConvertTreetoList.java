 package com.snc.day4.binarytrees;


public class ConvertTreetoList {
	
static class TreeNode{
		TreeNode right;
		TreeNode left;
		int data;
		TreeNode(int val){
			this.data=val;
		}
	}
	static class Pair 
	{ 
	TreeNode h; 
    TreeNode t; 
	Pair(){ h = t = null; } 
}  
	public static Pair treeToList(TreeNode r) {
		Pair p = new Pair(); 
    if(r == null) 
         return p; 
	if(r.left == null && r.right == null) {
		p.h = p.t = r;
	  return p; 
    } 

	Pair L = treeToList(r.left); 
	Pair R = treeToList(r.right); 

	if(r.left == null){ 
    p.h = r; 
	}else{ 
	r.left = L.t; 
	L.t.right = r; 
	p.h = L.h; 
   } 

	if(r.right == null){ 
     p.t = r; 
	}else{ 
	r.right = R.h; 
	R.h.left = r; 
	p.t = R.t; 
	} 
	return p; 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t = new TreeNode(5);
		t.left = new TreeNode(3);
		t.left.left = new TreeNode(4);
//		t.right = new TreeNode(8);
//		t.left.right = new TreeNode(4);
//		t.right.left= new TreeNode(6);
//		t.right.left.right= new TreeNode(7);
//		t.right.right= new TreeNode(20);
		
		treeToList(t);
	}

}
