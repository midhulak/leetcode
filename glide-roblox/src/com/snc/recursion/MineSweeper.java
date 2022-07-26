package com.snc.recursion;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!

You are given an m x n char matrix board representing the game board where:

'M' represents an unrevealed mine,
'E' represents an unrevealed empty square,
'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
'X' represents a revealed mine.
You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

Return the board after revealing this position according to the following rules:

If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
 

Example 1:


Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 * @author midhula.kadiyala
 *
 */

public class MineSweeper {
	
	 private int[][] dirs = { {0,1} , {0,-1} , {1,0} , {-1,0} , {-1,-1} , {1,1} , {1,-1} , {-1,1} }; 
		
		
		public char[][] updateBoard(char[][] board, int[] click){
			
			int row = click[0];
			int col = click[1];
			
			int m = board.length;
			int n= board[0].length;
			
			
			if(board[row][col] == 'M' || board[row][col] == 'X') {
				
				board[row][col] = 'X';
				return board;
			}
			
			int num=0;
			
			for(int[] dir : dirs) {
				int newRow = dir[0] + row;
				int newCol = dir[1] +col;
				//need to check all 8 dirtections if there is nay mine if any mine just count it and update it with click
				if(newRow >=0 && newRow < m && newCol >=0 && newCol < n && board[newRow][newCol] == 'M') {
					num++;
				}
			}
			//if num is greater than 0 that means some mines are there we just add that number over there
			if(num > 0) {
			board[row][col] = (char) (num +'0');
			return board;
			}
	        //if no mines are there we can just add as B that means this block does not have any ajacent mines
			board[row][col] = 'B';
			
			//then checking again  their adjacnet 8 directions which are E (empty squares) again checking recursively if there are any mines
			for(int[] dir : dirs) {
				
				int newRow = row+dir[0];
				int newCol = col+dir[1];
				
				if(newRow >=0 && newRow < m && newCol >=0 && newCol < n && board[newRow][newCol] == 'E') {
					updateBoard(board , new int[]{newRow , newCol});
				}
			}
			
			return board;
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
