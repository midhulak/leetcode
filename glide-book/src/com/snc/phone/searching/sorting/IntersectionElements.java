package com.snc.phone.searching.sorting;

import java.util.Set;
import java.util.HashSet;

public class IntersectionElements {
	
	//https://leetcode.com/problems/intersection-of-two-arrays/submissions/
	
	 /**
    Time complexity : \mathcal{O}(n + m)O(n+m), where n and m are arrays' lengths. \mathcal{O}(n)O(n) time is used to convert nums1 into set, \mathcal{O}(m)O(m) time is used to convert nums2, and contains/in operations are \mathcal{O}(1)O(1) in the average case.

Space complexity : \mathcal{O}(m + n)O(m+n) in the worst case when all elements in the arrays are different.

**/
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        
        for(int n1 : nums1){
            set1.add(n1);
        }
        
        HashSet<Integer> intersection = new HashSet<Integer>();
        
        for(int n2: nums2){
            if(set1.contains(n2))
                intersection.add(n2);
        }
        
        int[] result = new int[intersection.size()];
        
        int count=0;
        for(int res : intersection){
            result[count++] = res;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
