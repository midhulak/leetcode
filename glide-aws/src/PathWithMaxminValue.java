import java.util.PriorityQueue;

//need to return the unique paths and sum up each unique paths 
//and which unique path sum is greater among then get the samllest number. and in those need to return the minimum 
public class PathWithMaxminValue {

	
	 public static int maximumMinimumPath(int[][] A) {
			
			int m = A.length, n=A[0].length;
			boolean[][] visited = new boolean[m][n];
			PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[2] - a[2])); //this will atke care which direction to go next always going in a direction where maximum value next in 4 directions.
			pq.offer(new int[] {0,0,A[0][0]});
			
			int[][] dirs = {{-1,0} , {1,0} , {0,1} , {0,-1}};
			
			while(!pq.isEmpty()) {
				int[] curr = pq.poll();
				int r = curr[0], c = curr[1] , val = curr[2];
				visited[r][c] = true;
				
				if(r == m-1 && c == n-1) {
					return val;
				}
				
				for(int[] d : dirs) {
					int x = r + d[0];
					int y = c + d[1];
					if(x >=0 && x < m && y >= 0 && y<n && !visited[x][y]) {
						pq.offer(new int[] {x,y,Math.min(val , A[x][y])}); //whatever direction it goes it takes the min value in the path.
					}
				}
			
			}
			
			return -1;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] path = { {5,4,5} , {1,2,6} , {107,4,6} };
		System.out.println(maximumMinimumPath(path));
		
	}

}
