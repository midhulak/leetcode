package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DefuseBomb {
	HashMap<String, Integer> map = new HashMap<>();
	public void defuseBomb(String start, String disarm, String[] safe) {
		Integer id = 0;
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < safe.length; i++) {
			if(map.containsKey(safe[i])) {
				continue;
			}
			stack.push(safe[i]);
			while(!stack.isEmpty()) {
				String popVal = stack.pop();
				map.get(popVal).add(id);
				for(String neighbor : getSafeNeighbors(popVal)) {
					if(!map.containsKey(neighbor)) {
						stack.push(neighbor);
					}
					id++;
				}
			}
		}
		
	}
	public boolean areConnected(String start, String disarm) {
		if(map.get(Start) == map.get(disarm)) {
			return true;
		}
	}
}
