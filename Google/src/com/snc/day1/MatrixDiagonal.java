package com.snc.day1;

public class MatrixDiagonal {
	
	//if left to right row and col indices are same so 1 for loop is enough
	public static void printDiagonalLefttoRight(int[][] a) {
		
		for(int i=0 ; i<a.length; i++) {
			System.out.println(a[i][i]);
		}
		
		for(int i=a.length-1; i>=0 ; i--) {
			System.out.println(a[i][i]);
		}
		
	}
	
	
public static void printDiagonalRighttoLeft(int[][] a) {
	//print from top left to down
		int n = a.length-1;
		for(int i=0 ; i<=n; i++) {
			System.out.println(a[i][n-i]);
		}
		
		//print form bottomdown to up
		
		for(int i=n ; i>=0 ; i--) {
			
			System.out.println(a[i][n-i]);
		}
		
	}

public static void printAlltopLefttoDown(int[][] a) {
	int n= a.length;
	for(int r=0; r<n; r++) {
		
		int i=r; int j=0;
		
		while(i >= 0 && j<n) {
			System.out.print(a[i][j]);
			i--;
			j++;
		}
		
		System.out.println();
	}
	
for(int c=1; c<n; c++) {
		
		int i=n-1; int j=c;
		
		while(i >= 0 && j<n) {
			System.out.print(a[i][j]);
			i--;
			j++;
		}
		
		System.out.println();
	}
	
	
}

public static void printAllbottomtoTop(int[][] a) {
	int n= a.length;
	for(int r=n-1; r>=0; r--) {
		
		int i=n-1; int j=r;
		
		while(i >= 0 && j<n) {
			System.out.print(a[i][j]);
			i--;
			j++;
		}
		
		System.out.println();
	}
	
for(int c=n-2; c >= 0; c--) {

		
		int i=c; int j=0;
		
		while(i >= 0 && j<=n-2) {
			System.out.print(a[i][j]);
			i--;
			j++;
		}
		
		System.out.println();
	}
	
	
}


public static void printAllbottomtoTopReverse(int[][] a) {
	int n= a.length;
	for(int r=n-1; r >= 0; r--) {
		
		int j=n-1; int i=r;
		
		while(j >= 0 && i<n) {
			System.out.print(a[i][j]);
			i++;
			j--;
		}
		
		System.out.println();
	}
	
for(int c=n-2; c >= 0; c--) {
		
		int j=c; int i=0;
		
		while(j >= 0 && i<= n-2) {
			System.out.print(a[i][j]);
			i++;
			j--;
		}
		
		System.out.println();
	}
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { {1,2,3,4} , {5,6,7,8} , {9,10, 11, 12} , {13,14,15,16} };
//		printDiagonalLefttoRight(arr);  // 1 6 11 16   //16 11 6 1
//		printDiagonalRighttoLeft(arr); //4 7 10 13   13 10 7 4
//		printAlltopLefttoDown(arr); //1 [5 2] [9 6 3] [13 10 7 4] [14 11 8] [15 12] [16]
		printAllbottomtoTop(arr); // 16 [15 12] [14 11 8] [13 10 7 4] [9 6 3] [5 2] [1]
		printAllbottomtoTopReverse(arr); //16 [12 15] [8 11 14] [4 7 10 13] [3 6 9] [2 5] [1]
		
	}

}
