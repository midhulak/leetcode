package com.arrays;

public class SetMatrixZeros {
	
	  public void setZeroes(int[][] matrix) {
	        
	        int col0=1 ; int row = matrix.length; int col = matrix[0].length;
	        
	        //set first col has any zeos then set col0 to 0
	        for(int i=0; i<row; i++){
	            
	            if(matrix[i][0] == 0)
	                col0=0;
	            //if any position has 0 then set start of that row and start of taht col as 0
	            for(int j=1 ; j<col; j++){
	                if(matrix[i][j] == 0){
	                    matrix[i][0] = matrix[0][j] = 0;
	                }
	                
	            }
	            
	        }
	        
	        //come from reverse if start of col and start of row for that particular position is 
	        //0 then set that row and col is 0
	        for(int i=row-1; i>=0 ; i--){
	            for(int j=col-1; j>=1 ; j--){
	                
	                if(matrix[i][0] == 0 || matrix[0][j] == 0)
	                    matrix[i][j] = 0;
	                    
	                    
	            }
	            //if any row and col is zero position need to set that to zero as well.
	            if(col0 == 0)
	                        matrix[i][0] = 0;
	        }
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
