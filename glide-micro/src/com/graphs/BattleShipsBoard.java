package com.graphs;

public class BattleShipsBoard {

	 public int countBattleships(char[][] board) {
	        int battleShips =0;
	        
	        for(int i=0; i<board.length; i++){
	            for(int j=0 ; j<board[0].length; j++){
	                
	                if(board[i][j] == 'X'){
	                    dfs(board , i , j);
	                    battleShips++;
	                }
	                
	                
	            }
	        }
	        
	        return battleShips;
	    }
	    
	    public void dfs(char[][] board , int i , int j){
	        
	        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length  || board[i][j] != 'X')
	            return;
	        
	        board[i][j] = '*';
	        
	        dfs(board , i+1 , j);
	        dfs(board , i-1 , j);
	        dfs(board , i , j+1);
	        dfs(board , i , j-1);
	            
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
