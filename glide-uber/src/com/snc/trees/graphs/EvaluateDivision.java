package com.snc.trees.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
	/**
	 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.


	 * @param equations
	 * @param values
	 * @param queries
	 * @return
	 * https://leetcode.com/problems/evaluate-division/
	 */
	
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
	              
	                map.put(eq.get(0) , new HashMap<String , Double>());
	                }
	            map.get(eq.get(0)).put(eq.get(1) , values[i]);
	            
	             if(!map.containsKey(eq.get(1))){
	              
	                map.put(eq.get(1) , new HashMap<String , Double>());
	                }
	            map.get(eq.get(1)).put(eq.get(0) , 1/values[i]);
	        }
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
