package com.arrays;

public class SerchMatrixSorted {
	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        
	        int row = 0;
	        int col = matrix[0].length-1;
	        
	        while(row < matrix.length && col >= 0){
	            
	            if(matrix[row][col] == target)
	                return true;
	            
	            if(matrix[row][col] < target)
	                row++;
	            else
	                col--;
	                
	        }
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
