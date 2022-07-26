package com.snc.phone.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancePath {
	
	/**
	 * 
	 * https://leetcode.com/problems/shortest-distance-from-all-buildings/solution/
	 * Let NN and MM be the number of rows and columns in grid respectively.

Time Complexity: O(N^2 \cdot M^2)O(N 
2
 ⋅M 
2
 )

For each empty land, we will traverse to all other houses. This will require O(O(number of zeros \cdot⋅ number of ones)) time and the number of zeros and ones in the matrix is of order N \cdot MN⋅M. Consider that when half of the values in grid are 0 and half of the values are 1, the total elements in grid would be (M \cdot N)(M⋅N) so their counts are (M \cdot N)/2(M⋅N)/2 and (M \cdot N)/2(M⋅N)/2 respectively, thus giving time complexity (M \cdot N)/2 \cdot (M \cdot N)/2(M⋅N)/2⋅(M⋅N)/2, that results in O(N^2 \cdot M^2)O(N 
2
 ⋅M 
2
 ).

In JavaScript implementation, for simplicity, we have used an array for the queue. Since popping elements from the front of an array is an O(n) operation, which is undesirable, instead of popping from the front of the queue, we will iterate over the queue and record cells to be explored in the next level in next_queue. Once the current queue has been traversed, we simply set queue equal to the next_queue.

Space Complexity: O(N \cdot M)O(N⋅M)

We use an extra matrix to track the visited cells, and the queue will store each matrix element at most once during each BFS call. Hence, O(N \cdot M)O(N⋅M) space is required.
	 */
	
	private int[] rowDir = {1, -1, 0, 0};
    private int[] colDir = {0, 0, 1, -1};
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] canReach = new int[rows][cols];
        int[][] dist = new int[rows][cols];
        
        int totalBuildings = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    if (!bfs(grid, i, j, dist, canReach)) return -1;
                }
            }
        }
        
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReach[i][j] == totalBuildings &&
                   dist[i][j] < minDis) {
                    minDis = dist[i][j];
                }
            }
        }
        
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
    
    private boolean bfs(int[][] grid, int row, int col, int[][] dist, int[][] canReach) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        
        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            d++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int k = 0; k < 4; k++) {
                    int rr = rowDir[k] + r;
                    int cc = colDir[k] + c;
                    if (!isValid(grid, rr, cc, visited)) continue;                   
                    if (grid[rr][cc] == 0) {
                        dist[rr][cc] += d;
                        canReach[rr][cc]++;
                        q.offer(new int[]{rr, cc});                        
                    }
                    visited[rr][cc] = true;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(int[][] grid, int rr, int cc, boolean[][] visited) {
        if (rr > grid.length - 1 ||
           rr < 0 || cc < 0 || cc > grid[0].length - 1) return false;
        if (visited[rr][cc]) return false;
        if(grid[rr][cc] == 2) return false;
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {1,0,2,0,1} , {0,0,0,0,0} , {0,0,1,0,0}  };
		
		
		ShortestDistancePath s = new ShortestDistancePath();
		s.shortestDistance(grid);
	}

}
