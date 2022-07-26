package com.snc.day4.linkedlists.DoublyLinkedLists;


public class TwodimensionalDoubly {
	
	static class Node{
		Node next;
		Node prev;
		int val;
		Node(int val){
			this.val = val;
		}
		Node(){
			
		}
	}
	
	
	
	public static Node displayTwoDimensionalIterative(int[][] arr , int m , int n) {
		
		
		Node res = null;
		
		Node[] head = new Node[m];
		Node right = new Node();
		Node newPtr;
		
	
		for(int i=0 ; i<m; i++) {
			
			head[i] = null;
			
			for(int j=0 ; j<n; j++) {
				
				newPtr = new Node(arr[i][j]);
				
				if(res == null)
					res = newPtr;
				
				if(head[i] == null)
					head[i] = newPtr;
				right.next = newPtr;
				
				right = newPtr;
				
			}
		}
		
		
		for(int i=0 ; i< m-1; i++) {
			
			Node temp1 = head[i] ;
			Node temp2 = head[i+1];
			
			while(temp1 != null && temp2 != null) {
				temp1.prev = temp2;
				temp1 = temp1.next;
				temp2 = temp2.next;
				
			}
		}
		
		return res;
	}
	
	
	public static Node displayTwodimensionalRecursive(int[][] a , int i , int j , int m , int n) {
		
		  if (i > n - 1 || j > m - 1) 
	            return null; 
	  
	        // create a new node for current i and j 
	        // and recursively allocate its down and 
	        // right pointers 
	        Node temp = new Node(); 
	        temp.val = a[i][j]; 
	        temp.next = displayTwodimensionalRecursive(a, i, j + 1, m, n); 
	        temp.prev = displayTwodimensionalRecursive(a, i + 1, j, m, n); 
	        return temp; 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a = { {1,2,3,4} , {5,6,7,8} , {9,10,11,12} };
		
		//displayTwodimensionalRecursive(a , 0 , 0 , 3 ,4);
		displayTwoDimensionalIterative(a,3,4);
	}

}
