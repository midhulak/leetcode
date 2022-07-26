package com.snc.leetcodechallenges.feb;

import java.util.HashSet;
import java.util.Set;

public class numDistinctIslands {
	
	  static int rows=0;
	   static int cols=0;
	    public static int numDistinctIslands1(int[][] grid) {
	         rows = grid.length;
	        if(rows == 0)
	            return 0;
	         cols = grid[0].length;
	        Set<String> set = new HashSet<>();
	        
	        for(int i=0 ; i < rows; i++){
	            for(int j=0 ; j<cols; j++){
	                
	                if(grid[i][j] == 1){
	                   String path =  DFSMaking(grid , i , j , "X");
	                    set.add(path);
	                }
	            }
	        }
	        return set.size();
	    }
	    
	    
	    public static String DFSMaking(int[][] grid , int i , int j , String dir){
	        
	        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1){
	            return "O";
	        }
	        
	        grid[i][j] = 0;
	        //adding extra params to capture the path going in which direction.
	        String up = DFSMaking(grid , i-1 , j , "U"); 
	        String down = DFSMaking(grid , i+1 , j , "D");
	        String left = DFSMaking(grid , i , j-1 , "L");
	        String right = DFSMaking(grid , i , j+1 , "R");
	        
	        System.out.println(dir+up+down+left+right);
	        return  dir+up + down + left + right;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] grid = { {1,1,0,0,0} , {1,1,0,0,0} , {0,0,0,1,1} , {0,0,0,1,1} };
		int[][] grid1 = { {1,1,0,1,1} , {1,0,0,0,0} , {0,0,0,0,1} , {1,1,0,1,1} };
		
		System.out.println(numDistinctIslands1(grid));
		
	}

}
