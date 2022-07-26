package com.snc.linkedlist;

public class WordSearch {
	
	
public boolean exist(char[][] board, String word) {
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(i , j , 0 , word , board)){
                    
                  
                        return true;
                }
            }
        }
       return false; 
    }
    
    public boolean dfs(int i , int j , int count , String word , char[][] board){
        
        
        if(count == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j <0 || j >= board[0].length || board[i][j] != word.charAt(count))
            return false;
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        
        boolean found = dfs(i , j+1 , count+1 , word , board) ||
                         dfs(i , j-1 , count+1 , word, board) ||
                         dfs(i-1 , j , count+1, word , board) ||
                         dfs(i+1 , j , count+1 , word , board);
        
       
            board[i][j] = temp;
        return found;
        
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
