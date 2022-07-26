package com.snc.backTracking;

public class RatInMaze {
	
	
	static int count=0;
	public static boolean ratInMaze(int[][] maze) {
		
		for(int i=0 ; i<maze.length; i++) {
			for(int j=0 ; j<maze.length; j++) {
				
				if(maze[i][j] == 1) {
					if(dfs(i, j , maze)) {
						takeValid(maze);
						printSol(maze);
						return true;
				}
			}
		}
		
		
		}
		return false;
		
	}
	
	
	public static void takeValid(int[][] maze) {
		for(int i=0 ; i<maze.length; i++) {
			for(int j=0 ; j<maze[0].length; j++) {
				if(maze[i][j] == -1)
					maze[i][j] = 1;
				else
					maze[i][j] = 0;
			}
			
		}
	}
	
	public static void printSol(int[][] maze) {
		for(int i=0 ; i<maze.length; i++) {
			for(int j=0 ; j<maze[0].length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean dfs(int i , int j , int[][] maze) {
		
		if(i == maze.length-1 && j==maze.length-1 && maze[i][j] == 1) {
			maze[i][j] = -1;
			return true;
		}
		
		if(i < maze.length && j < maze[0].length && maze[i][j] == 1)
		{
			
			System.out.println("row is="+i+"col is="+j+"->");
			maze[i][j] = -1;
			if(dfs(i+1,j,maze))
				return true;
			if(dfs(i,j+1,maze))
			  return true;
			
			maze[i][j] = 0;
			return false;
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] maze = { {1,0,0,0} , {1,0,0,1} , {0,1,0,0} , {1,1,1,1} };
		
		ratInMaze(maze);
	}

}
