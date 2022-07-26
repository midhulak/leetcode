package com.snc.onsite.set1;

public class MaximalSquare {
	
	 public int maximalSquare(char[][] matrix) {
	        
	        if(matrix.length == 0)
	            return 0;
	        if(matrix[0].length == 0)
	            return 0;
	        
	        int[][] dp = new int[matrix.length][matrix[0].length];
	        int max=0;
	        
	        for(int i=0; i<matrix.length; i++){
	            for(int j=0; j<matrix[0].length; j++){
	                
	                
	                if(i == 0 || j ==0)
	                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
	                else if(matrix[i][j] == '1'){
	                    
	                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1] , dp[i-1][j])) + 1;
	                }
	                if(dp[i][j] > max)
	                    max=dp[i][j];
	                
	                
	                        }
	        }
	        
	        return max*max;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		MaximalSquare m = new MaximalSquare();
		System.out.println(m.maximalSquare(matrix));
		
	}

}
