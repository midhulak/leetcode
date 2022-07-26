package com.snc.backTracking;

import java.util.ArrayList;
import java.util.List;

public class DiffDirectionsRatInMaze {
	
	static List<String> list = new ArrayList<String>();
	static String path="";
	
	public static List<String> ratInMaze(int[][] maze){
		
		if(maze[maze.length-1][maze[0].length-1] != 1 || maze[0][0] != 1)
			return null;
		
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[0].length; j++) {
				
				if(maze[i][j] == 1) {
					
					dfs(maze , i , j);
					
				} 
			}
		}
		
		return list;
	}
	
	
	
	public static boolean  dfs(int[][] maze , int i , int j ) {
		
		if(i == maze.length-1 && j == maze[0].length-1 && maze[i][j] == 1) {
			list.add(path);
		
			return true;
		}
		
		if(i < maze.length && j< maze[0].length && maze[i][j] == 1) {
			maze[i][j] = -1;
			
		 if(dfs(maze , i+1 , j)) {
			 path+="D";
			 
		 }
		 
		 if(dfs(maze , i , j+1)) {
			 path+="R";
		 }
		 
		 maze[i][j]=0;
			return false;
		 
		}
		
		return false;
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[][] maze = { {1,1,0,0} , {1,1,0,1} , {1,1,0,0} , {1,1,1,1} };
		
       List<String> list = ratInMaze(maze);
       
       for(String key : list) {
    	   System.out.println("path is="+key);
       }
	}

}
