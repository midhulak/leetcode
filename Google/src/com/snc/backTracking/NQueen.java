package com.snc.backTracking;

public class NQueen {
	
	static int queens[][] ;
	static int rows=8;
	static int cols = 8;
	static int dirs[][] = { {-1,0} , {1,0} , {1,-1} , {0,1} , {-1,1} , {1,1} , {1,-1} , {-1,-1} };
	
	public static int[][] printNqueens(int[][] input) {
		queens = input;
		
		putQueen(0);
		return queens;
		
	}
	
	
	public static  boolean putQueen(int r) {
		
		if(r >= rows)
			return true;
		
		for(int c=0 ; c < cols ; c++) {
			
			if(DFS(r,c)) {
				queens[r][c] = 1;
				
				if(putQueen(r+1)) {
					return true;
				}
				else
					queens[r][c] = 0;
					
			}
			
		}
		return false;
	}
	
	
	
	public static boolean DFS(int i , int j) {
		
		//going upwards
		
		int r=i-1;
		int c=j;
		
		while(r>=0) {
			
			if(queens[r][c] == 1)
				return false;
			r--;
			
		}
			
		
		//going downwards
		 r = i+1;
		 c=j;
			while(r<rows) {
					
					if(queens[r][c] == 1)
						return false;
					r++;
					
				}
		
			//going left
			 r = i;
			 c=j-1;
				while(c>=0) {
						
						if(queens[r][c] == 1)
							return false;
						c--;
						
					}
				
				//going right
				r=i;
				c=j+1;
				
				while(c < cols) {
					if(queens[r][c] == 1)
						return false;
					c++;
				}
				
				//going diagonal  up right
				
				r=i-1;
				c=j+1;
				
				while(r >= 0 && c <cols) {
					
					if(queens[r][c] == 1)
						return false;
					r--;
					c++;
					
				}
				
//going diagonal  down right
				
				r=i+1;
				c=j+1;
				
				while(r <rows  && c <cols) {
					
					if(queens[r][c] == 1)
						return false;
					r++;
					c++;
					
				}
				
//going diagonal  left down
				
				r=i+1;
				c=j-1;
				
				while(r <rows  && c >=0) {
					
					if(queens[r][c] == 1)
						return false;
					r++;
					c--;
					
				}
				
//going diagonal  left up
				
				r=i-1;
				c=j-1;
				
				while(r >=0 && c >=0) {
					
					if(queens[r][c] == 1)
						return false;
					r--;
					c--;
					
				}
			
				return true;
		}
		
	
	
	public static void main(String args[]) {
		
		
	int[][] quuens =	printNqueens(new int[8][8]);
		
		for(int i=0 ; i<queens.length; i++) {
			
			for(int j=0 ; j<queens[0].length; j++) {
				
				System.out.print(queens[i][j]+" ");
			}
			
			System.out.println();
		}
		
	}

}
