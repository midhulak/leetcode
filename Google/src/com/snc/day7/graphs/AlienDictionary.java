package com.snc.day7.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	
	 public static String alienOrder(String[] words) {
	     
	        Map<Character, Set<Character>> graph = new HashMap<>();
	        int[] inDegree = new int[26];
	        buildGraph(graph, inDegree, words);
	        return bfs(graph, inDegree);
	    }

	    private static void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {
	        for (String s : words) {
	            for (char c : s.toCharArray()) {
	                graph.putIfAbsent(c, new HashSet<>());
	            }
	        }

	        for (int i = 1; i < words.length; i++) {
	            String first = words[i - 1];
	            String second = words[i];
	            int len = Math.min(first.length(), second.length());
	            for (int j = 0; j < len; j++) {
	                char out = first.charAt(j);
	                char in = second.charAt(j);
	                if (out != in) {                
	                    if (!graph.get(out).contains(in)) {
	                        graph.get(out).add(in);
	                        inDegree[in - 'a']++;
	                    }
	                    break;
	                }

	               
	                if (j + 1 == len && first.length() > second.length()) {
	                    graph.clear();
	                    return;
	                }
	            }
	        }
	    }

	    private static String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
	        StringBuilder sb = new StringBuilder();
	        Queue<Character> q = new LinkedList<>();
	        for (char c : graph.keySet()) {
	        	System.out.println("key is ="+c);
	        	Set<Character> set = graph.get(c);
	            if (inDegree[c - 'a'] == 0) {
	                q.offer(c);
	            }
	        }

	        while (!q.isEmpty()) {
	            char out = q.poll();
	            sb.append(out);
	            for (char in : graph.get(out)) {
	                inDegree[in - 'a']--;
	                if (inDegree[in - 'a'] == 0) {
	                    q.offer(in);
	                }
	            }
	        }

	        return sb.length() == graph.size() ? sb.toString() : "";
	    }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "wrt" , "wrf" , "er" , "ett" , "rftt"};

		alienOrder(words);
	}

}
