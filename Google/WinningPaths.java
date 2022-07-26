package Google;
import java.util.*;
//could there be multiple paths
//for example if path from A to b is path from b to a?
//It is kind of graph, where each node stores the incoming edges. 
public class WinningPaths {

//	public void init(int color) {
//		color = color;
//		List<Integer>list = new ArrayList<>();
//	}
	
	public static void scanWinningNodes(List<Integer>list, int playerColor, Set<Integer>set) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) != playerColor || set.contains(list.get(i))) {
				continue;
			}
			set.add(list.get(i));
			scanWinningNodes(list, playerColor,set);
		}
	}
	public static Set<Integer> findWinningStartingPoint(List<Integer>list, int playerColor, int winningColor) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == playerColor) {
				set.add(list.get(i));
			}
		}
		for(int i = 0; i < set.size(); i++) {
			scanWinningNodes(list, playerColor, set);
		}
		return set;
	}
	//follow-up
	/*we are left with finding circles and paths that lead to circles.
	 * We can scan the graph and everytime a circle closes, we can add all these nodes to the winning set. In this case,
	 * we dont need to revisit nodes from which we already backtracked, because if they were closing a circle
	 * they would have been part of the result set.
	 * gradually eliminating nodes that have 0 options from the graph, as well as all the incoming edges to such nodes. for this solution
	 * have to change the graph
	 */
	static class Node {
		int color;
		List<Integer> incoming;
		List<Integer> outgoing;
		Node(int color) {
			this.color = color;
			incoming = new ArrayList<>();
			outgoing = new ArrayList<>();
		}
	}
		public static boolean scanStuckNode(Node node, int playerColor, Set<Node>result,
				Set<Node>stuckNodes, Set<Node>visited) {
			if(result.contains(node)) {
				return true;
			}	
			if(stuckNodes.contains(node)) {
				return false;
			}
			if(visited.contains(node)) {
				return true;
			}
			visited.add(node);
			for(int i = 0; i < node.outgoing.size(); i++) {
				if(node.outgoing.get(i).node.color == playerColor 
						&& scanStuckNode(node.outgoing.get(i), playerColor, result, stuckNodes,visited)) {
					result.add(node);
					return true;
				}
			}
			stuckNodes.add(node);
			return false;
				
		}
		
		public static Set<Integer>findNoStuckStartPoints(List<Node>list, int playerColor, int winningColor) {
			Set<Integer> result = findNoStuckStartPoints(list, playerColor, winningColor);
			Set<Node>stuckNodes = new HashSet<>();
			Set<Node>visited = new HashSet<>();
			for(Node l : list) {
				if(l.color == playerColor) {
					scanStuckNode(l, playerColor, result, stuckNodes, visited);
				}
			}
			return result;
		}
	}
	
}
