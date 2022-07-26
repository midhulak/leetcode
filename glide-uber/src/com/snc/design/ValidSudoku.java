package com.snc.design;

import java.util.HashSet;

public class ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
		
		HashSet<String> seen = new HashSet();
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				
				char currentPos = board[i][j];
				
				if(currentPos != '.')
				{
					
					
			if(!seen.add(currentPos +"found in row" +i) ||
!seen.add(currentPos +"found in col" +j) || !seen.add(currentPos +"found in sub box" +i/3 + "-" +j/3))
				return false;
		
				}
				
				
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		set.add("apple");
		//if you try to add apple again it gives false
System.out.println("trying to add apple="+set.add("apple"));
System.out.println("trying to add pome"+set.add("pome"));
		
		
	}

}
