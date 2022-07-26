package com.snc.clari;

import java.util.PriorityQueue;

public class MergeKSortedArrays   {
	
	
	
	
	public static class Node{
		
		int arr;
		int arrIndex;
		int arrVal;
		
		public Node(int arr , int arrIndex , int arrVal) {
			this.arr = arr;
			this.arrIndex = arrIndex;
			this.arrVal = arrVal;
		}
	}
	
	static PriorityQueue<Node> queue = new PriorityQueue<Node>((Node a, Node b)->(a.arrVal - b.arrVal));
	
	
	public static int[] merge(int[][] arrays ) {
		int size=0;
		
		for(int i=0 ; i<arrays.length; i++) {
			
			size+= arrays[i].length;
			
			queue.add(new Node(i , 0 ,arrays[i][0]));
		}
		
		int[] result = new int[size];
		
		//{1,2,3} {4, 5, 6} {7, 8,9}   --> 1 ,4 , 7    (1 , 0, 4) (2 , 0 , 7) (0, 1 ,2)
		
		// , 1 0 4 , 2 0 7 , 0 1 2
	for(int i=0 ; !queue.isEmpty(); i++) {
		
		Node n = queue.poll();
		
		result[i] = n.arrVal;
		
		if( n.arrIndex+1 < arrays[n.arr].length) {
			queue.add(new Node(n.arr , n.arrIndex+1 , arrays[n.arr][n.arrIndex+1])); //0 , 1 , 2
		}
		
		
		
	}
		return result;
		
	}
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = { {1,3,4} ,{4,5,6} ,{7,9,8} };
		
		int[] result = merge(arrays);
		
		for(int i=0 ; i<result.length; i++) {
			System.out.print(result[i]);
		}

	}

	}
