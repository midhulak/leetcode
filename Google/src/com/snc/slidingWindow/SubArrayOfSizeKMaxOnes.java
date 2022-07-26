package com.snc.slidingWindow;

public class SubArrayOfSizeKMaxOnes {
	//subarray of size k
	//minimum swaps to required to move all 1's or zeros together 
	
	
	public static int[] subArarySize(int[] a , int k) {
		int maxCnt = 0; 
		int cnt=0;
		
int[] subarray=new int[2];
		for(int i=0; i<k; i++) 
           if(a[i] == 1) 
           	cnt++; 
	  maxCnt = cnt; 
	int s =0; int e = k; 

		while(e<a.length) 

		{ 

		if(a[e] == 1) 

		cnt++; 

		if(a[s] == 1) 

		cnt--; 

		 

		if(cnt>maxCnt) {

		maxCnt = cnt; 
		
		subarray=new int[]{s+1 , e};
		
		}

		e++; 

		s++; 

		}
		return subarray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,0,0,1,0,0,1,0,0,1,1,1,0,0};
		int[] res = subArarySize(a , 4);
		System.out.println("start index="+res[0]+"end index="+res[1]);
		
	}

}
