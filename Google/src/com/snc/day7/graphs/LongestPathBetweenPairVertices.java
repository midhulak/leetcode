package com.snc.day7.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestPathBetweenPairVertices {
	
	static class Cable{
		int source;
		int dest;
		int length;
	}
	
	public static void addEdgeWeight(int source , int dest , int length , List<List<Cable>> adj) {
		
		List<Cable> cableList = adj.get(source);
		
		Cable cable = new Cable();
		cable.source=source;
		cable.dest=dest;
		cable.length = length;
		
		cableList.add(cable);
		
		List<Cable> cableList1 = adj.get(dest);
		Cable cable2 = new Cable();
		cable2.source=dest;
		cable2.dest=source;
		cable2.length = length;
		
		cableList1.add(cable2);
	}
	
	
	
	public static int getCableLength(int source, int dest , List<List<Cable>> adj) {
		if(source < 1)
			return 0;
		
			int len=0;
		for(Cable c : adj.get(source)) {
			if(c.dest == dest) {
			
				return c.length;
			}
		}
		
		return len;
	}
	
	public static int DFSUtil(int v , int parent , List<List<Cable>> adj , boolean visited[] , Stack<String> path ) {
		
		
		visited[v] = true;
		
		int max=0;
		int maxChild=0;
		int maxParent =0;
		
		for(Cable c : adj.get(v)) {
			if(!visited[c.dest]) {
		  int len = 
				 DFSUtil(c.dest , v , adj , visited , path);
		  if(len > max) {
		     max=len;
			 maxChild = c.dest;
			 maxParent=v;
			 
		  }
			
		}
		
		}	
		
//		System.out.print("parent is="+parent);
//		System.out.print("child is="+v);
//		System.out.println("cable length is="+getCableLength(v , parent , adj));
		
		if(maxParent!=0 && maxChild!=0) {
			path.push(maxParent+"->"+maxChild);
			//System.out.println(maxParent+"->"+maxChild);
		}
	    return max + getCableLength(v , parent , adj );
	}
	
	public static int getMaxcableLength(List<List<Cable>> adj) {
		int maxResult=0;
		Stack<String> stackResult = new Stack<String>();
		
		for(int i=1; i<7; i++) {
			boolean visited[] = new boolean[7];
			Stack<String> stack = new Stack<String>();
		int maxLen=	DFSUtil(i , -1 ,  adj , visited , stack);
		
		if(maxLen > maxResult) {
			maxResult=maxLen;
			stackResult=stack;
		}
			
		}
		while(!stackResult.isEmpty()) {
			
			System.out.println(stackResult.pop());
		}
		
		return maxResult;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Cable>> adj = new ArrayList<List<Cable>>();
		
		for(int i=0 ; i<7; i++) {
			
			adj.add(new ArrayList<Cable>());
		}
		
		addEdgeWeight(1, 2 , 3 , adj);
		addEdgeWeight(2, 3 , 4 , adj);
		addEdgeWeight(2, 6 , 2 , adj);
		addEdgeWeight(6, 4 , 6 , adj);
		addEdgeWeight(6, 5 , 5 , adj);
		
		
		System.out.println("Max length is="+getMaxcableLength(adj));
		
	}

}
