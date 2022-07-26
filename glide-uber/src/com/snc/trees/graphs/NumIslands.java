package com.snc.trees.graphs;

public class NumIslands {
	
	 int rows=0;
	    int cols=0;
	    public int numIslands(char[][] grid) {
	        
	        rows= grid.length;
	         if(rows == 0)
	            return 0;
	        cols = grid[0].length;
	        int count=0;
	        
	       
	        
	        for(int i=0 ; i < rows; i++){
	            
	            for(int j=0; j < cols; j++){
	                
	                if(grid[i][j] == '1'){
	                    
	                    DFSMaking(grid , i , j);
	                    ++count;
	                }
	                
	            }
	        }
	        return count;
	    }
	    
	    public void DFSMaking(char[][] grid , int i , int j){
	        
	        if(i < 0  || j < 0 || i >= rows || j >= cols || grid[i][j] != '1' )
	            return;
	        
	        grid[i][j] = '0';
	        
	         DFSMaking(grid , i+1 , j);
	         DFSMaking(grid , i-1 , j);
	         DFSMaking(grid , i , j+1);
	         DFSMaking(grid , i , j-1);
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
