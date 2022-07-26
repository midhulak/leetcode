package com.snc.phone.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	
	/**
	 * https://leetcode.com/problems/alien-dictionary/solution/
    Let NN be the total number of strings in the input list.

Let CC be the total length of all the words in the input list, added together.

Let UU be the total number of unique letters in the alien alphabet. While this is limited to 2626 in the question description, we'll still look at how it would impact the complexity if it was not limited (as this could potentially be a follow-up question).

Time complexity : O(C)O(C).

There were three parts to the algorithm; identifying all the relations, putting them into an adjacency list, and then converting it into a valid alphabet ordering.

In the worst case, the first and second parts require checking every letter of every word (if the difference between two words was always in the last letter). This is O(C)O(C).

For the third part, recall that a breadth-first search has a cost of O(V + E)O(V+E), where VV is the number of vertices and EE is the number of edges. Our algorithm has the same cost as BFS, as it too is visiting each edge and node once (a node is visited once all of its edges are visited, unlike the traditional BFS where it is visited once one edge is visited). Therefore, determining the cost of our algorithm requires determining how many nodes and edges there are in the graph.
**/
	
	//topological sort
    public String alienOrder(String[] words) {
         Map<Character , Set<Character> > map = new HashMap<>();
        int[] indegree = new int[26];
        buildGraph(words , map , indegree);
        
        return bfs(map,indegree);
    }
    
    
    public void buildGraph(String[] words , Map<Character , Set<Character> > map , int[] indegree){
         
        for(String word : words){
            
          for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
    }
        
        for(int i=1 ; i<words.length; i++){
            
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length() , second.length());
            
            for(int j=0 ; j<len; j++){
                char in = first.charAt(j);
                char out = second.charAt(j);
                
                if(in != out){
                    if(!map.get(in).contains(out)){
                        map.get(in).add(out);
                        indegree[out - 'a']++;
                        
                    }
                    break;
                }
                
                if(j+1 == len && first.length() > second.length())
                {
                    map.clear();
                    return;
                    
                }
            }
        }
        
    }
    
    public String bfs(Map<Character , Set<Character>> map , int[] indegree){
        
        Queue<Character> queue = new LinkedList<>();
        
        for(char c : map.keySet()){
            if(indegree[c - 'a'] == 0)
                queue.offer(c);
        }
        //topological sort
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            
            char c = queue.poll();
            sb.append(c);
            for(char ch : map.get(c)){
                indegree[ch - 'a']--;
                if(indegree[ch - 'a'] == 0)
                {
                    queue.offer(ch);
                }
            }
        }
        return sb.length() == map.size() ? sb.toString() : "";
    }

}
