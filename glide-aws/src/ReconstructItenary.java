import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ReconstructItenary {
//	Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//			Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
	
	public static List<String> findItenary(List<List<String>> tickets){
		
		Map<String, LinkedList<String>> map = new HashMap<>();
		
//		MUC -> LHR
//		JFK -> MUC
//		SFO -> SJC
//		LHR -> SFO
		
		
	//	[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
				
//				JFK -> SFO,ATL,
//				SFO->ATL
//				ATL->JFK,SFO
				
			//	JFK->ATL->JFK->SFO->ATL->SFO
				
		//		["JFK","ATL","JFK","SFO","ATL","SFO"]
				
				
		for(List<String> tckt : tickets) {
			
		            String key = tckt.get(0);
		            LinkedList<String> cs = map.containsKey(key) ? map.get(key) : new LinkedList<>();
		            cs.add(tckt.get(1));
		            map.put(key, cs);
		        

		}
		
		for(String k : map.keySet()) {
			
			Collections.sort(map.get(k));
		}
		
		LinkedList<String> res = new LinkedList<String>();
		dfs(map,res,"JFK");
	
		
		return res;
		
	}
	
	public static void dfs(Map<String, LinkedList<String>> map , LinkedList<String> res , String key) {
		
		if(map.containsKey(key)) {
		
			LinkedList<String> set = map.get(key);
			
				
			Iterator<String> it = set.iterator();
			
			 while(!set.isEmpty()){
			       
				 String neigh = it.next();
				 set.remove(neigh);
				 
				 dfs(map,res,neigh);
			     }
		}
		
		
		res.offerFirst(key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
				
				List<String> list1 = new ArrayList<>();
		list1.add("JFK");
		list1.add("SFO");
		
		List<String> list2 = new ArrayList<>();
		list2.add("JFK");
		list2.add("ATL");
		
		List<String> list3 = new ArrayList<>();
		list3.add("SFO");
		list3.add("ATL");
		
		List<String> list4 = new ArrayList<>();
		list4.add("ATL");
		list4.add("JFK");
		
		List<String> list5 = new ArrayList<>();
		list5.add("ATL");
		list5.add("SFO");
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		list.add(list5);
	
		
	List<String> result=	findItenary(list);
	
	for(int i=0 ; i < result.size(); i++) {
		
		System.out.println(result.get(i));
	}
		

	}

}
