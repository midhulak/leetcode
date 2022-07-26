import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AncestorsORNOT {
	
	Map<Integer , Set<Integer>>  map = new HashMap<>();
	Set<Integer> child1Parents = new HashSet<>();
	Set<Integer> child2Parents = new HashSet<>();
	public boolean isAncestor(int[][] nodes , int child1 , int child2) {
		
		populateInMap(nodes);
		//child1Parents.add(child1);
		//child2Parents.add(child2);
		return dfs(child1 , child2);
		
		
	}
	
	
	public boolean dfs(int child1 , int child2) {
		
		for(Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			
			Set<Integer> set = entry.getValue();
			
			if(set.contains(child1)) {
				//child1Parents.add(child1);
				
				if(child2Parents.contains(entry.getKey()))
					return true;
				
				child1Parents.add(entry.getKey());
				return dfs(entry.getKey() , child2);
			}
			
			if(set.contains(child2)) {
				//child2Parents.add(child2);
				
				if(child1Parents.contains(entry.getKey()))
					return true;
				
				child2Parents.add(entry.getKey());
				return dfs(child1 , entry.getKey());
			}
			
		}
		
		return false;
	}
	
	public void populateInMap(int[][] nodes) {
		
		for(int i=0; i<nodes.length; i++) {
			
			if(map.containsKey(nodes[i][0])) {
				Set<Integer> set = map.get(nodes[i][0]);
				
				set.add(nodes[i][1]);
				
				map.put(nodes[i][0], set);
			}
			else {
           Set<Integer> set = new HashSet<>();
				
				set.add(nodes[i][1]);
				
				map.put(nodes[i][0], set);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodes = { {1,2} ,{1,3} , {1,7} , {3,4} , {3,5} , {5,6} , {5,8} , {5,11} , {6,10} , {6,14}, 
		{6,14} , {6,15} , {11,17}, {11,18} };
		
		int child1=11;
		int child2=17;
		
		AncestorsORNOT ances = new AncestorsORNOT();
		System.out.println(ances.isAncestor(nodes , child1 , child2));

	}

}
