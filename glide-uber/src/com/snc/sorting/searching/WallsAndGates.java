package com.snc.sorting.searching;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
	
	//apply bfs and get all gates and all directions just add 1 and again add those in the queue and do the process same
	
public void wallsAndGatesDFS(int[][] rooms) {
        
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[i].length; j++){
                if(rooms[i][j] == 0)
                    dfs(i , j , rooms , 0);
            }
        }
    }
    
    public void dfs(int i , int j , int[][] rooms , int shortDist){
        
        
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[i].length || rooms[i][j] < shortDist )
            return;
        
        
        rooms[i][j] = shortDist;
        
        dfs(i , j+1 , rooms , shortDist+1);
        dfs(i, j-1 , rooms , shortDist+1);
        dfs(i+1 , j , rooms , shortDist+1);
        dfs(i-1 , j , rooms , shortDist+1);
    }
	
	
	 public void wallsAndGatesBFS(int[][] rooms) {
         int[][] directions = { {0,1}, {0,-1} , {1,0} , {-1,0} };
      
       Queue<int[]> queue = new LinkedList<>();
      for(int i=0; i<rooms.length; i++){
          for(int j=0; j<rooms[i].length; j++){
              if(rooms[i][j] == 0)
                  queue.add(new int[]{i,j});
              
          }
      }
       
       while(!queue.isEmpty()){
           
           int[] fromDist = queue.poll();
           
           int row = fromDist[0];
           int col = fromDist[1];
           
           
           for(int[] allDir : directions){
               int r = row+allDir[0];
               int c = col+allDir[1];
               
               if(r < 0 || c < 0 || r >= rooms.length || c >= rooms[0].length ||   rooms[r][c] !=  2147483647){
                   continue;
               }
             
                    rooms[r][c] = rooms[row][col]+1;
            
               
            
             
               queue.add(new int[]{r,c});
               
           }
           }
       }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 }
