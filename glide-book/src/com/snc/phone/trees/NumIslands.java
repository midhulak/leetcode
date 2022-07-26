package com.snc.phone.trees;

public class NumIslands {
	
	  /**
    Time complexity : O(M \times N)O(M×N) where MM is the number of rows and NN is the number of columns.

Space complexity : worst case O(M \times N)O(M×N) in case 
that the grid map is filled with lands where DFS goes by M \times NM×N deep.

https://leetcode.com/problems/number-of-islands/solution/
*/
    int m=0;
    int n=0;
    public int numIslands(char[][] grid) {
        
    int m = grid.length;
      
        
        if(m == 0)
            return 0;
          int n = grid[0].length;
        int count=0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++ ){
                
                if(grid[i][j] == '1'){
                     dfs(i , j , grid , m , n);
                count++;
                }
            }
        }
        
        return count;
    }
    
    
    public void dfs(int i , int j , char[][] grid , int rowLen , int colLen){
        
        if(i < 0 || i >= rowLen || j < 0 || j >= colLen || grid[i][j] == '0')
            return ;
        
            grid[i][j] = '0';
            
            dfs(i , j-1 , grid , rowLen , colLen);
            dfs(i, j+1 , grid , rowLen , colLen);
            dfs(i-1 , j , grid , rowLen , colLen);
            dfs(i+1, j , grid , rowLen, colLen);
        
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
