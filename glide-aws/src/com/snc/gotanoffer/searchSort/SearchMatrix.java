package com.snc.gotanoffer.searchSort;

//search for a number in sorted 2d arary and integers in row sorted in 
//ascending from left to right.
public class SearchMatrix {
	//TC ; o(n+m) and SC : O(1)
	public boolean searchMatrix(int[][] matrix , int target) {
		int row = matrix.length-1;
		int col =0;
		
		while(row >=0 && col < matrix[0].length) {
			
			if(matrix[row][col] > target) {
				row--;
			}
			else if(matrix[row][col] < target){
			col++;
			}
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
