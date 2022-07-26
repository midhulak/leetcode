import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinarymatrix {
	//using bfs
		static int shortest = Integer.MAX_VALUE;
		public static int shortestPathBinaryMatrix(int[][] grid) {
			
			if(grid == null || grid.length == 0) {
				return -1;
			}
			int m = grid.length, n=grid[0].length;
			
			if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
				return -1;
			
			boolean[][] visited = new boolean[m][n];
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int[] {0,0});
			
			visited[0][0] = true;
			
			int level=0;
			int[][] dirs = {{-1,-1} ,{-1,0} , {-1,1} , {0,-1} , {0,1} , {1,-1} , {1,0} , {1,1}};
			while(!queue.isEmpty()) {
				int size = queue.size();
				level++;
				for(int i=0; i<size; i++) {
				int[] curr = queue.poll();
				if(curr[0] == m-1 && curr[1] == n-1)
					return level;
				
				for(int[] dir : dirs) {
					
					int x = curr[0]+dir[0];
					int y = curr[1]+dir[1];
					
					if(x < 0 || x > m-1 || y < 0 || y > n-1 || visited[x][y] || grid[x][y] == 1)
						continue;
					
					queue.offer(new int[] {x,y});
					visited[x][y] = true;
					
				}
				}
			}
			
			
			return -1;
	}
	
	//using dfs
	public static int shortestPathBinaryMatrix1(int[][] grid) {
		
		if(grid == null || grid.length == 0) {
			return -1;
		}
		int m = grid.length, n=grid[0].length;
		
		if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
			return -1;
		
		int[][] dirs = {{-1,-1} ,{-1,0} , {-1,1} , {0,-1} , {0,1} , {1,-1} , {1,0} , {1,1}};
		for(int i=0 ; i<m; i++) {
			for(int j=0 ; j<n; j++) {
				
				if(grid[i][j] == 0) 
				 dfs(i , j , grid , dirs , m ,n ,0);
				
				
				
			}
		}
			
			return shortest == Integer.MAX_VALUE ? -1 : shortest;
		
	}
	
	public static void dfs(int row , int col , int[][] grid , int[][] dirs , int m , int n ,  int dist) {
		
		for(int[] dir : dirs) {
			
			int x = row+dir[0];
			int y = col+dir[1];
			
			if(x < 0 || x > m-1 || y < 0 || y > n-1 ||  grid[x][y] == 1)
				return;
			
			grid[x][y] = 1;
			
			if(x == m-1 && y==n-1) {
				shortest = Math.min(shortest , dist);
				return;
			}
			
			dfs(x , y , grid , dirs , m , n ,  dist+1);
		}
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] grid= {{0,0,0},{1,1,0},{1,1,0}};
		
		System.out.println(shortestPathBinaryMatrix1(grid));
	}

}
