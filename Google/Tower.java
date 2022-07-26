package Google;

import java.util.*;

public class Tower {
	static class Node {
		int val;
		Node(int x, int y) {
			val = x * 10 + y;
		}
	}
	static class DSU {
		Map<Integer, Integer> parent;
		DSU(){
			parent = new HashMap<>();
		}
		void addParent(Node node) {
			parent.put(node.val, node.val);
		}
		int getParent(Node node) {
			return parent.get(node.val);
		}
		int find(int p) {
			while(p != parent.get(p)) {
				parent.put(p,  parent.get(find(parent.get(p))));
				p = parent.get(p);
			}
			return p;
		}
		public void union(Node x, Node y) {
			int parentX = find(x.val);
			int parentY = find(y.val);
			if(parentX == parentY) {
				return;
			}
			if(parentX % 10 > parentY % 10) {
				parent.put(parentY, parentX);
			} else {
				parent.put(parentX, parentY);
			}
		}
	}
	static class ServiceTower {
		int buildServiceTower(int rows, int cols) {
			DSU dsu = new DSU();
			int days = 0;
			int[][] dirs = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
			Map<Integer, Node> nodeMap = new HashMap<>();
			int nextNode = 0;
			boolean connected = false;
			while(true) {
				int[]next = CIT.nextTower();
				days++;
				Node node = new Node(next[0], next[1]);
				nodeMap.put(node.val, node);
				dsu.addParent(node);
				for(int[]dir : dirs) {
					nextNode = (node.val / 10 + dir[0]) * 10 + (node.val % 10 + dir[1]);
					if(nodeMap.containsKey(nextNode)) {
						dsu.union(node,  nodeMap.get(nextNode));
					}
				}
				for(Map.Entry<Integer, Node> nodes :nodeMap.entrySet()) {
					int key = nodes.getKey();
					if(key / 10 == 0 && dsu.find(key) % 10 == cols - 1) {
						CIT.stop();
						connected = true;
						break;
					}
				} 
				if(connected) {
					break;
				}
			}
			return days;
		}
		static class CIT {
			static int[]nextTower() {
				return new int[] {1, 2};
			}
			static void stop() {
				
			}
			private CIT() {
				
			}
		}
	}
}
