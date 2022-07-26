package com.snc.day7.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountPossiblePaths {
	
static ArrayList<String> resultList = new ArrayList<String>();
	
public static void addEdge(String u , String v , Map<String , ArrayList<String>> map ) {
	    ArrayList<String> list = map.get(u);
	    list.add(v);
	    map.put(u, list);
		}
	

public static void dfs(String source , String curr , String dest , String path , Map<String , ArrayList<String>> map) {
	
	path+=curr+" ";
	
	if(curr == dest) {
		resultList.add(path);
		path=source+" ";
		return;
	}
	
	
	
	if(map.containsKey(curr)) {
		
		for(String s : map.get(curr)) {
			dfs(source , s ,dest, path ,map);
		}
	}
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int v = 5;
		String str[] = {"A" , "B" , "C" , "D" , "E"};
		Map<String , ArrayList<String>> map = new HashMap<String ,  ArrayList<String>>();
		for(int i=0 ; i<v; i++) {
			map.put(str[i], new ArrayList<String>());
		}
		addEdge("A","B",map);
		addEdge("A","C",map);
		//addEdge("C","A",map);
		addEdge("A","E",map);
		addEdge("B","D",map);
		addEdge("B","E",map);
		addEdge("C","E",map);
		addEdge("D","C",map);
		
		dfs("A" , "A" , "E" , "" , map);
		
		for(int i=0 ; i<resultList.size();i++) {
			System.out.println(resultList.get(i));
		}
	}

}
