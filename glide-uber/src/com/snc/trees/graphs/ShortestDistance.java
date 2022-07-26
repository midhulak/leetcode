package com.snc.trees.graphs;
import java.util.LinkedList;
import java.util.Queue;



public class ShortestDistance {


		  
		  

		static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
	    
	    int[][] dirs = {{0,1} , {0 ,-1} , {1,0} , {-1 , 0} };
	    int row = grid.length;
	    int col = grid[0].length;
	    
	   System.out.println("row sis="+row+"cols is="+col);
	    if(grid[sr][sc] == 0)
	      return -1;
	    
	Queue<int[]> queue = new LinkedList<>();
	    
	    queue.add(new int[]{sr , sc});
	    
	    int level=0;
	    
	    while(!queue.isEmpty()){   // 0,0
	      
	      int size = queue.size();
	      //System.out.println("size is="+size);
	      
	      for(int i=0; i<size; i++){
	        
	        int[] currDir = queue.remove();
	        
	        int r1 = currDir[0];
	        int c1 = currDir[1];
	        
	        if(r1 == tr && c1 == tc) {
	        	//System.out.println("level is="+level);
	          return level;
	        }
	        
	        for(int[] d : dirs){
	         int r = d[0]+r1;
	          int c= c1+d[1];
	          
	          if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0)
	            continue;
	          
	          queue.add(new int[]{r , c});
	          
	        }
	        
	        
	      }
	      
	      level++;
	      
	      
	      
	    }
	    
	    System.out.println("level is="+level);
	    return level;
	    
	    
	    
		}

		public static void main(String[] args) {
	    
	    int[][] grid = { {1,1,1,1} , {0,0,0,1} , {1,1,1,1} };
	    
	    //Solution s = new Solution();
	    System.out.println(shortestCellPath(grid , 0,0,2,0));
		
		}
	

}
