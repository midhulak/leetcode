package com.snc.compass;
import java.util.HashSet;
import java.util.Set;
/**
 * Time complexity : O(M \times N)O(M×N) where MM is the number of rows and NN is the number of columns.

Space complexity : worst case O(M \times N)O(M×N) in case that the grid map is filled with lands where DFS goes by M \times NM×N deep.
 * @author midhula.kadiyala
 *
 */
public class NumberIslands {
	
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
	//Time complexity O(M*N)
	    //we must iterate over every eklement int he grid
	    //space complexity : O(M * N)
	    // our recursion depth will be potentially be M * N
 public int numDistinctIslands(char[][] grid) {
	        
	        rows= grid.length;
	         if(rows == 0)
	            return 0;
	        cols = grid[0].length;
	        
	        //uisng set to add distict elements
	       Set<String> set = new HashSet<>();
	        
	        for(int i=0 ; i < rows; i++){
	            
	            for(int j=0; j < cols; j++){
	                
	                if(grid[i][j] == '1'){
	                    //passing directions to capture
	                  String path = DFSMakingDistinct(grid , i , j , "X");
	                  set.add(path);
	                    
	                }
	                
	            }
	        }
	        return set.size();
	    }
 
 public String DFSMakingDistinct(char[][] grid , int i , int j , String dir){
     
     if(i < 0  || j < 0 || i >= rows || j >= cols || grid[i][j] != '1' )
         return "O";
     
     grid[i][j] = '0';
     
      String down =  DFSMakingDistinct(grid , i+1 , j , "D");
      String up = DFSMakingDistinct(grid , i-1 , j ,"U");
      String right= DFSMakingDistinct(grid , i , j+1 , "R");
      String left =DFSMakingDistinct(grid , i , j-1 , "L");
      
      return dir+down+up+right+left;
     
 }
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
