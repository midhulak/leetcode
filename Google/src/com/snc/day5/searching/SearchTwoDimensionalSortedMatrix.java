package com.snc.day5.searching;

public class SearchTwoDimensionalSortedMatrix {
	
	
	public static boolean searchMatrix(int[][] a , int val) {
		
		
		int row=0 ;
		int col=a.length-1;
		
		while(row < a.length && col >= 0) {
			
			if(val == a[row][col])
				return true;
			
			if(a[row][col] > val)
				col--;
			
			row++;
			
		}
	return false;
	}
	
	
	public static  int serachBinary(int[][] a ) {
		
		int row=0;
		int col = a.length-1;
		int res=-1;
		
		while(row < a.length-1 && col >= 0) {
			
			if(a[row][col] == 1) {
				res=col;
				col--;
			}
			else
			row++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] a = { {1,5,8,10} , {2,6,11,13} , {4,9,15,20} , {7,12,17,30} };
		
		System.out.println(searchMatrix(a , 100));
	}

}
