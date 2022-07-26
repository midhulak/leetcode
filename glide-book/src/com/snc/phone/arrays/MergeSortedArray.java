package com.snc.phone.arrays;

public class MergeSortedArray {
	
	//https://leetcode.com/problems/merge-sorted-array/solution/
	
	/**
	 * Time complexity: \mathcal{O}((n + m)\log(n + m))O((n+m)log(n+m)).

The cost of sorting a list of length xx using a built-in sorting algorithm is \mathcal{O}(x \log x)O(xlogx). Because in this case we're sorting a list of length m + nm+n, we get a total time complexity of \mathcal{O}((n + m) \log (n + m))O((n+m)log(n+m)).

Space complexity: \mathcal{O}(n)O(n), but it can vary.

Most programming languages have a built-in sorting algorithm that uses \mathcal{O}(n)O(n) space.


	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i=m-1;
	        int j= n-1;
	        
	        int k = m+n-1;
	        
	        
	        while(k >=0 && i >=0 && j>=0 ){
	            if(nums2[j] >= nums1[i]){
	                nums1[k] = nums2[j--];
	            }
	            
	            else
	                nums1[k] = nums1[i--];
	             k--;
	        }
	        
	        while(i >= 0 && k >=0){
	            nums1[k] = nums1[i];
	            i--;
	            k--;
	        }
	        
	        while(j >= 0 && k>=0){
	            nums1[k] = nums2[j];
	            j--;
	            k--;
	        }
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
