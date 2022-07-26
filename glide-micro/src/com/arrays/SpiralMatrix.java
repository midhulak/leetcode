package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	   public List<Integer> spiralOrder(int[][] a) {
		     if(a.length ==0 )
		         return new ArrayList<Integer>();
		        List<Integer> toReturn = new ArrayList<Integer>();
		        
		        
				int sr=0;
				int sc=0;
				int er=a.length-1;
				int ec= a[0].length-1;
				
				while(sr <= er && sc <= ec) { 
					
				for(int i=sr; i<=ec; i++) {
					toReturn.add(a[sr][i]);
				}
				
				for(int i= sr+1 ; i<=er; i++) {
		           
					toReturn.add(a[i][ec]);
				}

				for(int i=ec-1; i>=sc ; i--) {
		            if(sr == er)
		                break;
					toReturn.add(a[er][i]);
				}
				
				//already sr printed..so we can not give >=
				for(int i=er-1; i>sr ; i--) {
		            if(sc == ec)
		                break;
					toReturn.add(a[i][sc]);
				}
				
				sr++;
				sc++;
				er--;
				ec--;
				
			}
		  
		        return toReturn;
		    }
	   
	   
	   
	   public int[][] spiralOrder(int n) {
		   
		   int[][] matrix = new int[n][n];
		    
		        
		        
				int sr=0;
				int sc=0;
				int er=n-1;
				int ec= n-1;
				int count=1;
				
				while(sr <= er && sc <= ec) { 
					
				for(int i=sr; i<=ec; i++) {
					matrix[sr][i] = count++;
				}
				
				for(int i= sr+1 ; i<=er; i++) {
		           
					matrix[i][ec] = count++;
				}

				for(int i=ec-1; i>=sc ; i--) {
		            if(sr == er)
		                break;
		            matrix[er][i]=count++;
				}
				
				//already sr printed..so we can not give >=
				for(int i=er-1; i>sr ; i--) {
		            if(sc == ec)
		                break;
		            matrix[i][sc]=count++;
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
		
		SpiralMatrix sp = new SpiralMatrix();
		int[][] matr = sp.spiralOrder(3);
		
		for(int i=0; i< matr.length; i++) {
			for(int j=0; j<matr.length; j++)
			System.out.print(matr[i][j]);
			
			System.out.println();
		}
		
		
	}

}
