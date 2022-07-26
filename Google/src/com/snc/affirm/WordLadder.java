package com.snc.affirm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	private static void bfs(String start , String end , Set<String> dict , HashMap<String , ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance){
	    
	    for(String str : dict)
	        nodeNeighbors.put(str , new ArrayList<String>());
	    
	    Queue<String> queue = new LinkedList<String>();
	    queue.offer(start);
	    
	    distance.put(start, 0);

	    
	     while(!queue.isEmpty()){
	         
	         int count = queue.size();
	         boolean foundEnd=false;
	         for(int i=0 ; i< count ; i++){
	             
	             String curr = queue.poll();
	             
	             int currDistance = distance.get(curr);
	             
	             ArrayList<String> neighbours = getNeighbours(curr , dict);
	             
	             for(String neighbour : neighbours){
	                 
	                 nodeNeighbors.get(curr).add(neighbour);
	                 
	                 if(!distance.containsKey(neighbour)){
	                     distance.put(neighbour , currDistance+1);
	                 
	                 
	                 if(end.equals(neighbour))
	                     foundEnd = true;
	                 
	                 else
	                     queue.offer(neighbour);
	                 }
	                 
	             }
	             
	             
	         }
	         
	         if(foundEnd)
	             break;
	         
	     }
	    
	    
	}
	     
	public static void dfs(String cur , String end , Set<String> dict , HashMap<String , ArrayList<String>> nodeNeighbours , HashMap<String , Integer> distance , ArrayList<String> solution, 
	                          List<List<String>> res){
	      solution.add(cur);
	    
	    if(end.equals(cur)){
	        res.add(new ArrayList<String>(solution));
	        
	    }
	    
	    else{
	        
	        for(String next : nodeNeighbours.get(cur)){
	            
	            if(distance.get(next) == distance.get(cur) + 1){
	                dfs(next , end , dict , nodeNeighbours , distance , solution , res);
	            }
	        }
	    }
	        solution.remove(solution.size() -1);
	    }
	    
	    
	    //Find all next level nodes
	    
	    private static ArrayList<String> getNeighbours(String node , Set<String> dict){
	        ArrayList<String> res = new ArrayList<String>();
	        
	        char chs[] = node.toCharArray();
	        
	        for(char ch='a'; ch <= 'z' ; ch++){
	            for(int i=0 ; i < chs.length; i++){
	                
	                if(chs[i] == ch) continue;
	                
	                char old_ch = chs[i];
	                
	                chs[i] = ch;
	                //checking is this value present or not
	                 if(dict.contains(String.valueOf(chs))){
	                     res.add(String.valueOf(chs));
	                     
	                 }
	                chs[i] = old_ch;
	            }
	        }
	        
	        return res;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
