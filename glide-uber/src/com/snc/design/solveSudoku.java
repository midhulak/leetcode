package com.snc.design;

public class solveSudoku {
	
	 public void solveSudoku(char[][] board) {
	        sudoko(board , 0 , 0);
	    }
	    
	    
	    
	    public void sudoko(char[][] board , int row , int col){
	        
	        if(row == board.length)
	            return;
	         //check if we reach end of the col 
	        
	        
	        int nextCol=0;
	        int nextRow=0;
	        
	        if(col == board[0].length-1){
	            nextCol= 0;
	            nextRow = row+1;
	        }
	        else{
	            nextRow = row;
	            nextCol = col+1;
	        }
	        
	        
	        if(board[row][col] != '.')
	           sudoko(board , nextRow , nextCol);
	        else
	        {
	            for(int posOptions=1; posOptions<= 9 ; posOptions++){
	                
	                if(isValid(board , row , col , posOptions)){
	                    board[row][col] = (char)posOptions;
	                   sudoko(board , nextRow , nextCol);
	                    board[row][col] ='.';
	                }
	                
	            }
	            
	        }
	        
	   
	    }
	    
	    
	    
	    public boolean isValid(char[][] board , int row , int col , int val){
	        
	        //check that col has that option
	        for(int i=0; i<9; i++){
	            
	            if(board[row][i] == (char)val)
	                return false;
	            
	        }
	        
	        //check taht row has that option
	         for(int i=0; i<9; i++){
	            
	            if(board[i][col] ==  (char)val)
	                return false;
	            
	        }
	        
	        int subrowStart = 3 * (row/3);
	        int subcolStart = 3 * (col/3);
	        
	         //check that sub row has that option
	        
	        for(int x=0; x<3; x++){
	            for(int y=0; y<3; y++){
	                if(board[subrowStart+x][subcolStart+y] ==  (char)val)
	                    return false;
	            }
	            
	        }
	        
	        return true;
	    }

}
