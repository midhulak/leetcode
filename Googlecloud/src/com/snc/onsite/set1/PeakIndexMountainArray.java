package com.snc.onsite.set1;

public class PeakIndexMountainArray {
	
	 public int peakIndexInMountainArray(int[] arr) {

    
      int lo = 0, hi = arr.length - 1;
      while (lo < hi) {
          int mi = lo + (hi - lo) / 2;
          if (arr[mi] < arr[mi + 1])
              lo = mi + 1;
          else
              hi = mi;
      }
      return lo;
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
