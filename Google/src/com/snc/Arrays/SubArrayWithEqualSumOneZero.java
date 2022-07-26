package com.snc.Arrays;

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;


public class SubArrayWithEqualSumOneZero {

	//Initial Template for Java

	// } Driver Code Ends


	//User function Template for Java


	    //Function to count subarrays with 1s and 0s.
	    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
	    {
	        Map<Integer , Integer> map = new HashMap<>();
	        int count=0;
	        int sum=0;
	        
	        for(int i=0 ; i<n ; i++){
	            
	        sum+= arr[i] == 0 ? -1 : 1;
	        
	        if(sum == 0)
	         count++;
	         
	         if(map.containsKey(sum)){
	             count+=map.get(sum);
	             map.put(sum , map.get(sum)+1);
	         }
	         else
	         map.put(sum , 1);
	        }
	        return count;
	        // add your code here
	    }
	

}
