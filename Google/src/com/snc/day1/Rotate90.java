package com.snc.day1;

public class Rotate90 {
	
//	   1 2 3   3 6 9
//	   4 5 6   2 5 8
//	   7 8 9   1 4 7

	//without extra space start
	  static void reverseColumns(int arr[][]) 
	    { 
	        for (int i = 0; i < arr[0].length; i++) 
	            for (int j = 0, k = arr[0].length - 1; 
	                 j < k; j++, k--) { 
	                int temp = arr[j][i]; 
	                arr[j][i] = arr[k][i]; 
	                arr[k][i] = temp; 
	            } 
	    } 
	  
	    // Function for do transpose of matrix 
	    static void transpose(int arr[][]) 
	    { 
	        for (int i = 0; i < arr.length; i++) 
	            for (int j = i; j < arr[0].length; 
	                 j++) { 
	                int temp = arr[j][i]; 
	                arr[j][i] = arr[i][j]; 
	                arr[i][j] = temp; 
	            } 
	    } 
	  
	    // Function for print matrix 
	    static void printMatrix(int arr[][]) 
	    { 
	        for (int i = 0; i < arr.length; i++) { 
	            for (int j = 0; j < arr[0].length; 
	                 j++) 
	                System.out.print(arr[i][j] + " "); 
	            System.out.println(""); 
	        } 
	    } 
	  
	    // Function to anticlockwise rotate 
	    // matrix by 90 degree 
	    static void rotate90(int arr[][]) 
	    { 
	        transpose(arr); 
	        reverseColumns(arr); 
	    } 
	    //with out extra space end
	
	public static int[][] rotate(int[][] mat) {
		
		int mat1[][] =new int[mat[0].length][mat.length];
		int ec=mat[0].length-1;
		
		for(int i=0 ; i<mat[0].length; i++) {
			for(int j=0 ; j<mat.length; j++) {
				
				mat1[i][j] = mat[j][ec];
				
				
			}
			ec--;
		}
		return mat1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] matrix = { {1,2,3,4} , {5,6,7,8} , {9,10,11,12} , {13,14,15,16}};
		
		int[][] matrix = { {1,2,3,4} , {5,6,7,8}};
		
		
		int[][] rote = rotate(matrix);

		for(int i=0 ; i<rote.length; i++) {
			for(int j=0; j<rote[0].length; j++) {
				
				System.out.print(rote[i][j]+" ");
			}
			System.out.println("");
		}
		
	}

}
