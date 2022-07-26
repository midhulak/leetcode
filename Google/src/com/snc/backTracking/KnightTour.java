package com.snc.backTracking;

import java.util.Arrays;

public class KnightTour {
	
	static int[][] dir =  { {2,1} , {-2,1} , {2,-1} , {-2,-1} , {1,2} , {-1,2} , {1,-2} , {-1,-2}};
	
	static int[][] board = new int[8][8];
	 static int rows = board.length;
	 static  int cols = board[0].length;
	static int nums=0;
    
	
	public static void knighttour() {
		
		// board[0][0] = -1;
		for(int i=0 ; i<board.length; i++)
		 Arrays.fill(board[i] , -1);
		 
		 for(int i=0 ; i<rows; i++) {
			 
			 for(int j=0 ; j<cols; j++) {
				 
				 if(board[i][j] == -1) {
					 
					 dfs(i , j);
				 }
			 }
			 
		 }
		
		for(int i=0 ; i<rows; i++) {
			for(int k=0 ; k<cols; k++) {
				
				System.out.print(board[i][k]+"    ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int i , int j) {
		
		for(int k=0 ; k<dir.length; k++) {
			
			int r =i+ dir[k][0];
			int c= j+ dir[k][1];
			
			while(r < rows && r >= 0 && c < cols && c >=0 && board[r][c] == -1 ) {
					
				board[r][c] = nums++;
				dfs(r,c);
				
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knighttour();
	}

}
