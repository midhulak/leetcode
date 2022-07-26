import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.

Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.

Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).

 */

/*
 *   /* step#1 fill teh graph with n*n 2 dimensional array and fill all values initially with -n
    step#2 build graph by iterating to rededges and go like matrix from to 0 to 1 like 0th row 1st col mark as 1 for red
    step#3 and also iterate teh blue edges and go same like if teh value is 1 taht means taht nod eis already there then put 0 otherwise put -1 so that it is blue edge
    step#4 initialize a queue and offer 0,1 and 0,-1 initially and also take len variable set to 0 and also initialize res variable which is filled with max values of size n
    step#5 then do bfs if queu is not empty get teh size and also increment length and iterate queue with size and inside poll the curr value from queue and
    get teh node and also find teh opposite color (that is just negate the value in queu and iterate a loop till n starts from 1 and check in build graph if build graph node and j value is equal to either opposite color or 0 then add those j space opposite coloe to teh set and also offer it to teh queue
    and also set res[j] = math.min(res[j] , len))
    step#5 finally just iterate from re if it is still maxvalue just add -1 and retrun actual result.
    then initialize a queue of int[] 
    */


public class ShortestPathAlternativeColors {
	
	 public static int[] shortestAlternatingPaths(int n, int[][] red_edges,
		        int[][] blue_edges) {
		        int[][] g = new int[n][n]; //initially fill with some number which is negate n i.e -n
		        buildGraph(g, n, red_edges, blue_edges);

		        Queue<int[]> q = new LinkedList<>();
		        q.offer(new int[]{0, 1});
		        q.offer(new int[]{0, -1});
		        int len = 0;
		        int[] res = new int[n];
		        Arrays.fill(res, Integer.MAX_VALUE);
		        res[0] = 0;

		        Set<String> visited = new HashSet<>();
		        while (!q.isEmpty()) {
		            int size = q.size();
		            len++;
		            for (int i = 0; i < size; i++) {
		                int[] cur = q.poll();
		                int node = cur[0];
		                int color = cur[1];
		                int oppoColor = -color;   //checking firstly rednode with opposite color if it is there we add it to set and also add those in queue and also len to result.
		                

		                for (int j = 1; j < n; j++) {
		                    if (g[node][j] == oppoColor ||
		                       g[node][j] == 0) {
		                        if (!visited.add(j + "" + oppoColor)) continue;
		                        q.offer(new int[]{j, oppoColor});
		                        res[j] = Math.min(res[j], len);
		                    }
		                }
		            }
		        }

		        for (int i = 1; i < n; i++) {
		            if (res[i] == Integer.MAX_VALUE) {
		                res[i] = -1;
		            }
		        }

		        return res;
		    }

		    private static void buildGraph(int[][] g, int n, 
		        int[][] red_edges, int[][] blue_edges) {
		        for (int i = 0; i < n; i++) {
		            Arrays.fill(g[i], -n);  //fill all arrays with 0
		        }

		        //go to red array and fill the graph with those indeces with 1
		        for (int[] e : red_edges) {
		            int from = e[0];
		            int to = e[1];
		            g[from][to] = 1;
		        }
//got o blue arary and fill the graph if it is 1 means already rededge then mark it as 0 if not then mark it as -1
		        for (int[] e : blue_edges) {
		            int from = e[0];
		            int to = e[1];
		            if (g[from][to] == 1) {
		                g[from][to] = 0;
		            } else {
		                g[from][to] = -1;
		            }
		        }
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=3;
		int[][] red = {{0,1} };
		int[][] blue = {{1,2}};
		shortestAlternatingPaths(n , red , blue);
		
	}

}
