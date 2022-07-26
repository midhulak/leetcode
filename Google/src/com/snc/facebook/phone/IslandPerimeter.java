package com.snc.facebook.phone;

import java.util.Arrays;
import java.util.List;

public class IslandPerimeter {
	
	 List<int[]> DIRECTIONS = Arrays.asList( new int[]{-1,0} , new int[]{1,0} , new int[]{0, -1} , new int[]{0 , 1});
	    public int islandPerimeter(int[][] grid) {
	        
	        if(grid == null || grid.length < 1)
	            return 0;
	        
	        int rows = grid.length;
	        int cols = grid[0].length;
	        int perimeter=0;
	        for(int i=0 ; i < rows; i++){
	            for(int j=0 ; j<cols; j++){
	                
	                if(grid[i][j] == 1)
	                    perimeter+=getPerimeter(grid , rows , cols , i , j);
	            }
	        }
	        return perimeter;
	    }
	    
	    public int getPerimeter(int[][] grid , int rows , int cols , int i , int j){
	        int perimeter =0 ;
	        
	        int a = i;
	        int b = j;
	        
	        for(int[] dir : DIRECTIONS){
	            
	            a+=dir[0];
	            b+=dir[1];
	            
	            if(a <0 || a >= rows || b <0 || b >= cols || grid[a][b] == 0)
	                perimeter++;
	            
	            a=i;
	            b=j;
	        }
	        return perimeter;
	    }

}
