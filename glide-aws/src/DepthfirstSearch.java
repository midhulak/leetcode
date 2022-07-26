import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DepthfirstSearch {
	
	 private static  Map<Integer , List<Integer>> map;
	 
	private static Set<Integer> set;
	public static boolean validTree(int n, int[][] edges) {
     map = new HashMap<>();
        if(edges.length != n-1)
        	return false;
	for(int i=0; i<edges.length; i++){
		
		int k = edges[i][0];
		
	List<Integer> list = map.containsKey(k) ? map.get(k) : new ArrayList();
	
	list.add(edges[i][1]);
	map.put(k, list);
			
		}
	
	 set = new HashSet<>();
		
	return dfs(0 , -1) && set.size() == n;
	
	
  }
  
    public static  boolean  dfs(int node , int parent ) {
		
		if(set.contains(node)) 
		{
			
			return false;
		}
		
		set.add(node);
		
		if(map.containsKey(node)) {
			for(int neigh : map.get(node)) {
				if(neigh != parent) {
			boolean result = dfs(neigh , node );
			
			if(!result)
				return false;
				}
			}
			
		}
		
       return true;
		
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
int[][] edges = { {0,1} , {0,2} , {0,3} , {1,4} };

 System.out.println(validTree(5 , edges));

	}

}
