package Google;

public class SquareGrids {
	int uf[N] = {0,1,2,3};
	int sz[N] = {1,1,1,1};
	public static int find(int root) {
		if(uf[root] == root) {
			return root;
		} else {
			uf[root] = find(uf[root]);
		}
	}
	public void union(int x, int y) {
		int xx = find(x);
		int yy = find(y);
		if(xx == yy) {
			return;
		}
		if(sz[xx] > sz[yy]) {
			uf[yy] = xx;
			sz[xx] += sz[yy];
		} else {
			uf[xx] = yy;
			sz[yy] += sz[xx];
		}
	}
}
