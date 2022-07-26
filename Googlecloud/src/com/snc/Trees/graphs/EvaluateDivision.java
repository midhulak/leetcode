package com.snc.Trees.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	
	//https://www.youtube.com/watch?v=1NkeOHsHbs0
	
	//first trying to build a map with reciprocals and then just doing normal dfs
	
	 public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	        
	        Map<String , Map<String, Double>> map = new HashMap<>();
	        
	        buildMap(map , equations , values);
	        double[] res = new double[queries.size()];
	        
	        for(int i=0; i<queries.size(); i++){
	            
	            List<String> query = queries.get(i);
	            Set<String> visited = new HashSet<>();
	            
	            Double d = dfs(map , query.get(0) , query.get(1)  , visited);
	            res[i] = d == null ? -1 : d;
	        }
	        
	        return res;
	        
	    }
	    
	    
	    
	    
	    public Double dfs(Map<String , Map<String, Double>> map  , String q1 , String q2 ,   Set<String> visited ){
	        
	        if(visited.contains(q1))
	            return null;
	        
	        
	        if(!map.containsKey(q1) || !map.containsKey(q2))
	            return null;
	        
	        if(map.get(q1) != null && map.get(q1).get(q2) != null)
	            return map.get(q1).get(q2);
	        
	        visited.add(q1);
	        
	        Map<String , Double> map1 = map.get(q1);
	        
	        for(String s : map1.keySet()){
	            
	            Double d = dfs(map , s , q2 , visited);
	            
	            if(d != null)
	                return d*map1.get(s);
	        }
	        
	        return null;
	    }
	    
	    public void buildMap(Map<String , Map<String, Double>> map ,List<List<String>> equations , double[] values ){
	        
	        for(int i=0; i<equations.size(); i++){
	            
	            List<String> eq = equations.get(i);
	            if(!map.containsKey(eq.get(0))){
	              
	                map.put(eq.get(0) , new HashMap<String , Double>()); //a , new hm
	                }
	            map.get(eq.get(0)).put(eq.get(1) , values[i]);   //b, 2.0  ->. a , (b, 2.0)
	            
	             if(!map.containsKey(eq.get(1))){
	              
	                map.put(eq.get(1) , new HashMap<String , Double>());  //b , new hm
	                }
	            map.get(eq.get(1)).put(eq.get(0) , 1/values[i]); // a , 1/2. -> b , (a , 1/2)
	        }
	    }
	    
	    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
