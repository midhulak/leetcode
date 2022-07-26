package com.arrays;

public class RotateImage {
//transpose convert rows to cols and cols to rows
	//reverse
	
	
	 public void rotate(int[][] matrix) {
         //transpose conver t rows to cols and cols to rows
       
       for(int i=0 ; i<matrix.length; i++){
           for(int j=i; j<matrix[0].length; j++){
               
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
           }
       }
       
       for(int i=0; i<matrix.length; i++){
           for(int j=0; j<matrix.length/2; j++){
               
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][matrix.length-j-1];
               matrix[i][matrix.length-j-1] = temp;
           }
       }
       
       
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
