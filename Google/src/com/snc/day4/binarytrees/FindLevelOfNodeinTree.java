package com.snc.day4.binarytrees;


public class FindLevelOfNodeinTree {
	
static class TreeNode{
		
		TreeNode right;
		TreeNode left;
		int data;
		TreeNode(int val){
			this.data=val;
		}
	}
	
	
	public static int getLevel(TreeNode r,int val , int c1) {
		
		if(r == null)
			return -1;
		if(r.data == val)
			return c1;
		
		int x =getLevel(r.left , val , c1+1);
		
		if(x != -1)
			return x;
		return getLevel(r.right , val , c1+1);
		
	}
	
	
public static int getLevel(TreeNode r,int val) {
		
		if(r == null)
			return -1;
		if(r.data == val)
			return 1;
		
		int x = 1 + (getLevel(r.left , val));
		
		if(x != 0 && x != 1)
			return x;
		
			return 1 + (getLevel(r.right , val));
		
		
		
	}

public static int getLevel1(TreeNode r, int val) 

{ 

if(r == null){ return -1; } 

if(r.data == val){ return 0; } 

 

int x = getLevel(r.left, val); 

 

if(x != -1) 

return x+1; 

 

x = getLevel(r.right, val); 

 

if(x == -1) 

return x; 

else 

return x+1; 

} 


public static int getLevelTra(TreeNode r , int val) {
	
	return getLevel(r,val) - 1;
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
		
		System.out.println(getLevelTra(t , 7 ));
		
	}

}
