package com.snc.trees.graphs;
public class SurroundRegions {
	
	 public void solve(char[][] board) {
	        
	        //checking boundary condtions if there is only 1 row or only 1 column then no way it is surrounded by X
	        int R = board.length;
	        if(R <=2)
	            return;
	        int C = board[0].length;
	        if(C <= 2)
	            return;
	        
	        //first looking is there any 0 in boundaries if any o in boundary do dfs call on 4 sides and mark with some temp character.
	        
	        for(int i=0; i<R; i++){
	            for(int j=0; j<C; j++){
	                
	                if(board[i][j] == 'O' && (i==0 || j==0 || i == R-1 || j == C-1))
	                   dfs(board , i , j);
	            }
	        }
	        
	        
	        for(int i=0; i<R; i++){
	            for(int j=0; j <C; j++){
	                
	                if(board[i][j] == 'A')
	                    board[i][j] = 'O';
	                
	               else if(board[i][j] == 'O')
	                    board[i][j] = 'X';
	            }
	        }
	        
	    }
	                   
	                   
	  public void dfs(char[][] board , int i , int j){
	      if(i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != 'O')
	          return;
	      
	      board[i][j] = 'A';
	      
	      dfs(board ,i , j+1);
	      dfs(board , i+1 , j);
	      dfs(board, i-1 , j);
	      dfs(board, i , j-1);
	      
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
