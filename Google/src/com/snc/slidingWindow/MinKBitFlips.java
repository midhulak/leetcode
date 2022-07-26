package com.snc.slidingWindow;

public class MinKBitFlips {
	
	 public int  minKBitFlips(int[] A, int k) 

	 { 
	         int cnt=0;

	 if(k > A.length) return -1; //IMPOSSIBLE 

	  

	 if(k < A.length) return -1; //IMPOSSIBLE 

	  int n=A.length;

	 for(int i=0; i<n-k; i++) 

	 if(A[i] == '-') 

	 { 

	 flip(A, i, k); 

	 cnt++; 

	 } 

	 for(int i =n-k; i<n; i++) 

	 { 

	 if(A[i] == '-') 

	 return -1;

	 } 

	       return cnt;
	 } 

	     //flip teh positions form i to k
	     public static void flip(int[] A , int i , int k){
	         
	         
	         for(int start=i; start<k; start++){
	             
	             if(A[start] == 1)
	                 A[start]= 0;
	             
	             else
	                 A[start]= 1;
	         }
	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
