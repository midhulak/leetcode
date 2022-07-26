package com.snc.trees.graphs;

public class QuadTree {
	
	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    
	    public Node() {
	        this.val = false;
	        this.isLeaf = false;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = null;
	        this.topRight = null;
	        this.bottomLeft = null;
	        this.bottomRight = null;
	    }
	    
	    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
	        this.val = val;
	        this.isLeaf = isLeaf;
	        this.topLeft = topLeft;
	        this.topRight = topRight;
	        this.bottomLeft = bottomLeft;
	        this.bottomRight = bottomRight;
	    }
	}
	
	  public Node construct(int[][] grid) {
	        
	        return construct(grid , 0 , grid.length-1 , 0 , grid[0].length-1);
	        
	    }
	    
	    public Node construct(int[][] grid, int left , int right , int up , int down){
	        
	        
	        Node node = new Node();
	        
	        if(isSame(grid , left , right , up ,down)){
	            node.isLeaf = true;
	            node.val = grid[up][left] == 1;
	            return node;
	        }
	        
	        
	        node.isLeaf=false;
	        node.topLeft = construct(grid , left , (left+right)/2 , up , (up+down)/2);
	        node.topRight = construct(grid, (left + right)/2+1 , right , up , (up+down)/2);
	        node.bottomLeft = construct(grid , left , (left + right)/2 , (up+down)/2+1 , down);
	        node.bottomRight = construct(grid, (left+right)/2+1 , right , (up+down)/2+1 , down);
	        
	        return node;
	    }
	    
	    private boolean isSame(int[][] grid , int left , int right , int up , int down){
	        int val = -1;
	        
	        for(int i=up; i<= down; i++){
	            for(int j=left; j<= right; j++){
	                
	                if(val == -1)
	                    val = grid[i][j];
	                
	                else if(val != grid[i][j])
	                    return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
