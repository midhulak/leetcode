package com.snc.phone.searching.sorting;

public class FirstBadVersion {
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
//when ever we find bad version will stretch till left until how long the bad version is there 
//if we find no bad version. again will stretch until how long the bad version is not there and we can return low

//TC: O(logn)
//SC: O(1)
//https://leetcode.com/problems/first-bad-version/solution/
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
      
      int low=0 ; int high = n;
      
      while(low<=high){
          int mid= low+(high -low)/2;
          //BadVersion is an api
          if(isBadVersion(mid)){
          high=mid-1;
              
          }
          
          else
              low=mid+1;
          
          
              
      }
      return low;
  }
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
