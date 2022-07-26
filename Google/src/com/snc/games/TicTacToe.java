package com.snc.games;

public class TicTacToe {

	int[] rowCounter;
    int[] colCounter;
    int diagLeft;
    int diagRight;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
      rowCounter = new int[n];
         colCounter = new int[n];
         diagLeft=0;
         diagRight=0;
        this.n=n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        int move = player == 1? 1 : -1;
        
        rowCounter[row]+= move;
        colCounter[col]+= move;
        
        if(row == col)
            diagLeft+=move;
        if(row == n-col-1)
            diagRight+=move;
        
        if(rowCounter[row] == n || colCounter[col] == n || diagLeft == n || diagRight == n)
            return 1;
          if(rowCounter[row] == -n || colCounter[col] == -n || diagLeft == -n || diagRight == -n)
            return 2;
        
        else
            return 0;
        
    }
}

