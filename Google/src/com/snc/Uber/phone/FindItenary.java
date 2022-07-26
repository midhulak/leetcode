package com.snc.Uber.phone;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class FindItenary {
	
	 public static List<String> findItinerary(List<List<String>> tickets) {
	        
	        List<String> result = new ArrayList<String>();
	        Map<String , List<String>> map = new HashMap<>();
	        
	        
	        for(List<String> ticket : tickets){
	            
	          String source = ticket.get(0);
	            String dest = ticket.get(1);
	            
	            if(map.containsKey(source)){
	                
	                List<String> list = map.get(source);
	                list.add(dest);
	                map.put(source , list);
	            }
	            else{
	                List<String> list = new ArrayList<String>();
	                list.add(dest);
	                map.put(source , list);
	            }
	            
	            }
	        
	        List<String> list = map.get("JFK");
	        Collections.sort(list);
	        
	        DFS(list.get(0) , result , map);
	        return result;
	          
	        }
	    
	    
	    public static void DFS( String source , List<String> result , Map<String, List<String>> map){
	        
	        result.add(source);
	        
	        for(String adj : map.get(source)){
	            String nextDest = adj;
	            List<String> list = map.get(source);
	            
	            list.remove(nextDest);
	            DFS(nextDest , result , map);
	        }
	        
	    }
	        

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> list = new ArrayList<>();
		

		List<String> list1= new ArrayList<>();
		list1.add("MUC");
		list1.add("LHR");
		
		list.add(list1);
		
		List<String> list2= new ArrayList<>();
		list2.add("JFK");
		list2.add("MUC");
		list.add(list2);
		
		List<String> list3= new ArrayList<>();
		list3.add("SFO");
		list3.add("SJC");
		list.add(list3);
		
		List<String> list4= new ArrayList<>();
		list4.add("LHR");
		list4.add("SFO");
		list.add(list4);
		
		System.out.println(findItinerary(list));
		
	}

}
