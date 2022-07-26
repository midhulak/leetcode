package com.snc.day1;

import java.text.DecimalFormat;

public class WaterPyramid {
	
	
	public static void printPat(int N, int Cap) {
		
		int r=0;
		int[][] a = new int[N][N];
		
		a[0][0] = N;
		
		boolean isSpilOver = a[0][0] > Cap;
		
		while(isSpilOver) {
			
			isSpilOver = false;
			for(int c=0; c<=r; c++) {
				
				if(a[r][c] > Cap) {
					
					double temp = a[r][c] - Cap;
					
					a[r+1][c]+= temp/2;
					System.out.print(a[r+1][c]);
					a[r+1][c+1]+= temp/2;
					System.out.print(a[r+1][c+1]);
					
					a[r][c]=Cap;
					System.out.print(a[r][c]);
					isSpilOver=true;
					
					
				}
			}
			r++;
		}
		
	}
	
	public static void printPyramid(int n) {
		DecimalFormat df2 = new DecimalFormat(".#");
		int sum =n;
		for(int i=1; i<=n ; i++) {
			System.out.println();
			for(int j=1 ; j<=n-i; j++) {
				System.out.print(" ");
			}
			if(sum >= i) {
				for(int k=1 ; k<=i ; k++) {
					System.out.print("1 ");
					sum--;
					}
			}
					else {
						if(sum > 0) {
							for(int k=1; k<=i; k++) {
								System.out.print(df2.format((double)sum/i)+" ");
						}
							return;
					}
				}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printPyramid(10);
		printPat(7,1);

	}

}
