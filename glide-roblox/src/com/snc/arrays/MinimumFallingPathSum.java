package com.snc.arrays;

import java.util.HashMap;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


 * @author midhula.kadiyala
 *
 */

public class MinimumFallingPathSum {
	
	 public int minFallingPathSum(int[][] matrix) {
	        
	        
	        int ans = Integer.MAX_VALUE;
	        HashMap<String , Integer> hm = new HashMap<>();
	        
	        for(int i=0; i<matrix.length; i++){
	            
	            ans = Math.min(ans , dfs(0 , i , matrix , hm));
	        }
	        
	        return ans;
	    }
	    
	    
	    public int dfs(int i , int j , int[][] matrix , HashMap<String , Integer> hm){
	        
	        int row = matrix.length;
	        int col = matrix[0].length;
	        
	        if(i == row)
	            return 0;
	        
	        if(j < 0 || j >= col)
	            return Integer.MAX_VALUE;
	        
	        String key = i+"#"+j;
	        if(hm.containsKey(key))
	         return hm.get(key);
	        //have to go in 3 directions and see what i sthe minum path in between
	        int left = dfs(i+1, j-1 , matrix , hm);
	        int middle = dfs(i+1,j,matrix , hm);
	        int right = dfs(i+1,j+1,matrix, hm);
	        
	        hm.put(key , matrix[i][j] + Math.min(left , Math.min(middle , right)));
	        return matrix[i][j] + Math.min(left , Math.min(middle , right));
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
