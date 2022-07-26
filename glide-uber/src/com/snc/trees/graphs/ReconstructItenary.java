package com.snc.trees.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/reconstruct-itinerary/solution/
 * @author midhula.kadiyala
 * 
 * Time complexity = O(E^n)
 * space complexity = O(V+E)
 *
 */
public class ReconstructItenary {
	
public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String , PriorityQueue<String>> map = new HashMap<>();
        
        
        for(List<String> ticket : tickets){
            
            String key = ticket.get(0);
            String val = ticket.get(1);
            
            
            if(map.containsKey(key))
                map.get(key).add(val);
                
            else
            {
                PriorityQueue<String> p = new PriorityQueue<>();
                p.add(val);
                map.put(key , p);
            }
            
        }
        
        LinkedList<String> res = new LinkedList<>();
         
        dfs(res , map , "JFK");
        return res;
        
    }
    
    
    public void dfs(LinkedList<String> res ,    Map<String , PriorityQueue<String>> map , String str){
            PriorityQueue<String> s = map.get(str);
        while(s!= null && !s.isEmpty()){
        
            dfs(res , map ,s.poll());
                
            }
        res.addFirst(str);
    }
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
