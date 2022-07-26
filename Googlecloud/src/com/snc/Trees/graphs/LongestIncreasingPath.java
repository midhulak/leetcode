package com.snc.Trees.graphs;

public class LongestIncreasingPath {
	
public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp= new int[rows][cols];
        
        int res = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                
                
                if(dp[i][j] == 0){
                    dfs(i , j , matrix , dp , Integer.MIN_VALUE);
                    res=Math.max(res , dp[i][j]);
                    
                }
                
            }
        }
        return res;
    }
    
    private int dfs(int row , int col , int[][] matrix , int[][] dp , int prev){
        
        if(row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0 || matrix[row][col] <= prev)
            return 0;
        
        if(dp[row][col] != 0)
            return dp[row][col];
        
        
        int left = dfs(row , col-1 , matrix , dp , matrix[row][col]);
        int right = dfs(row , col+1 , matrix , dp , matrix[row][col]);
        int up = dfs(row-1 , col , matrix , dp , matrix[row][col]);
        int down = dfs(row+1 , col , matrix , dp , matrix[row][col]);
            
          dp[row][col] = Math.max(left , Math.max(right , Math.max(up , down))) + 1;;
        
        return dp[row][col];
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
