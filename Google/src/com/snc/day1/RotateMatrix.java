package com.snc.day1;

public class RotateMatrix {
	
//	1 2 3    4 1 2
//	4 5 6    7 5 3 
//	7 8 9    8 9 6

	
	public static int[][] rotateMatrix(int[][] matrix) {
		
		int sr = 0;
		int sc = 0;
		int er=matrix.length-1;
		int ec=matrix[0].length-1;
		
	
		
		while(sr<er && sc<ec) {
			int prev = matrix[sr+1][sc];
		
	
		for(int i=sr; i<=ec; i++) {
			
			int curr = matrix[sr][i];
			matrix[sr][i] = prev;
			System.out.print(matrix[sr][i]+",");
			prev=curr;
		}
		
		for(int i=sr+1; i<=er; i++) {
			
			int curr = matrix[i][ec];
			matrix[i][ec] = prev;
			System.out.print(matrix[i][ec]+",");
			prev=curr;
		}
		
		
		for(int i=ec-1; i>=sc; i--) {
			if(sr == er)
				break;
			int curr = matrix[er][i];
			matrix[er][i] = prev;
			System.out.print(matrix[er][i]+",");
			prev=curr;
		}
		
		for(int i=er-1; i>sr; i--) {
			if(sc == ec)
				break;
			int curr = matrix[i][sc];
			matrix[i][sc] = prev;
			System.out.print(matrix[i][sc]+",");
			prev=curr;
		}
		sr++;
		sc++;
		er--;
		ec--;
		
	}
		return matrix;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[][] matrix = { {1,2,3,4} , {5,6,7,8} , {9,10,11,12} , {13,14,15,16}};
		
	int[][] rote =	rotateMatrix(matrix);
	System.out.println(">>>>>>");
	for(int i=0 ; i<rote.length; i++) {
		for(int j=0; j<rote[0].length; j++) {
			
			System.out.print(rote[i][j]+" ");
		}
		System.out.println("");
	}
		
	}

}
