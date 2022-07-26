package com.snc.phone.searching.sorting;

public class SearchInRotatedSortedArray {
	
	//TC: O(logn)
	//SC: O(1)
	//https://leetcode.com/problems/search-in-rotated-sorted-array/
	
	  public int search(int[] A, int target) {
	      	//for rotated sorted array last index will be less than first index
		  //we can apply normal binary serach and check at which suddenly the elements started decreasing.
	        int low = 0;
	        int high = A.length-1;
	        // Find the index of the smallest value using binary search.
	        // Loop will terminate since mid < hi, and low or high 
	        // will shrink by at least 1.
	        
	        // Proof by contradiction that mid < high: if mid==high, 
	        // then low == high and loop would have been terminated.
	        while(low < high){
	            int mid = (low + high)/2;
	            if(A[mid] > A[high]){
	                low = mid+1;
	            }
	            else {
	                high = mid;
	            }
	        }
	        
	        
	   
	      System.out.println("pivot index is="+low);
	        // low = high is the index of the smallest value 
	        // and also the number of places rotated.
	       int rot=low;
	        low = 0;
	        high = A.length-1;
	        // The usual binary search and accounting for rotation.
	        while(low <= high){
	            int mid = (low + high)/2;
	            int realmid=(mid + rot) % A.length;
	            if(A[realmid] == target){
	                return realmid;
	            }
	            if( target > A[realmid] ){
	                low = mid+1;
	            }
	            else {
	                high = mid-1;
	            }
	        }
	        return -1;
	}
	    

}
