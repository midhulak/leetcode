package com.snc.day1;

public class SpiralMatrix {
	
	
	
	
	public static void printSpiral(int[][] a) {
		
		int sr=0;
		int sc=0;
		int er=a.length-1;
		int ec= a[0].length-1;
		
		while(sr <= er && sc <= ec) { 
			
		for(int i=sr; i<=ec; i++) {
			System.out.print(a[sr][i]+",");
		}
		
		for(int i= sr+1 ; i<=er; i++) {
			System.out.print(a[i][ec]+",");
		}

		for(int i=ec-1; i>=sc ; i--) {
			
			if(sr == er)
				break;
			System.out.print(a[er][i]+",");
		}
		
		//already sr printed..so we can not give >=
		for(int i=er-1; i>sr ; i--) {
			
			if(sc == ec)
				break;
			System.out.print(a[i][sc]+",");
		}
		
		sr++;
		sc++;
		er--;
		ec--;
		
	}
	}
	
	public static void main(String[] args) {
		
		int[][] arr= { {1,2,3,4} , {5,6,7,8} , {9,10,11,12}  };
		
		
		
		printSpiral(arr);
	}

}
