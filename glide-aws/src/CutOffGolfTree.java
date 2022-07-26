import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffGolfTree {
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	
	public static  int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < forest.size(); ++r) {
            for (int c = 0; c < forest.get(0).size(); ++c) {
                int v = forest.get(r).get(c);
                if (v > 1) trees.add(new int[]{v, r, c}); //if >1 adding those into list of integers...
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0])); //sort by tree height

        int ans = 0, sr = 0, sc = 0; //starting from 0th row and 0th col send each tree row and col ,and it do dfs and if it ia able to cut that tree it gives teh value where it cuts.
        for (int[] tree: trees) {
            int d = dist(forest, sr, sc, tree[1], tree[2]);
            if (d < 0) return -1;
            ans += d;
            sr = tree[1]; sc = tree[2];
        }
        return ans;
    }
	

	public static int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
	    int R = forest.size(), C = forest.get(0).size();
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{sr, sc, 0});
	    boolean[][] seen = new boolean[R][C];
	    seen[sr][sc] = true;
	    while (!queue.isEmpty()) {
	        int[] cur = queue.poll();
	        if (cur[0] == tr && cur[1] == tc) // will check the row and col where we cut is equal to given tree row and tree col
                return cur[2];
	        for (int di = 0; di < 4; ++di) {
	            int r = cur[0] + dr[di];
	            int c = cur[1] + dc[di];
	            if (0 <= r && r < R && 0 <= c && c < C &&
	                    !seen[r][c] && forest.get(r).get(c) > 0) {
	                seen[r][c] = true;
	                queue.add(new int[]{r, c, cur[2]+1});
	            }
	        }
	    }
	    return -1;
}

}
