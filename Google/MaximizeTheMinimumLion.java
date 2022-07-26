package Google;

import java.util.LinkedList;
import java.util.Queue;

public class MaximizeTheMinimumLion {
	public static int maxTheMin(int[][]grid, int[]start) {
		Queue<Integer[]>queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int temp = queue.pop();
			if(grid[grid.length][grid[0].length] = temp) {
				return grid.length;
			}
			for(int neightbor : )
		}
	}
}
