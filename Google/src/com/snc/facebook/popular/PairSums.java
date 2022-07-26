package com.snc.facebook.popular;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
	
	static int numberOfWays(int[] arr, int k) {
		    // Write your code here
		    
		    Map<Integer , Integer> map = new HashMap<>();
		    int count=0;
		    
		    for(int i=0 ; i<arr.length; i++){
		      
		      if(map.containsKey(k-arr[i])){
		        count+=map.get(k-arr[i]);
		        if(k-arr[i] == arr[i])
		        map.put(k-arr[i] , map.get(k-arr[i])+1);
		      }
		     
		      if(!map.containsKey(arr[i]))
		        map.put(arr[i] , 1);
		      
		    }
		   
		    return count;
		  }




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int k=6;
		int[] arr = {1,5,3,3,3};
		
		numberOfWays(arr , k);
		

	}

}
