package com.snc.phone.arrays;

import java.util.PriorityQueue;

/*
 * Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

0 ≤ k ≤ 20
[output] array.integer
 * Time Complexity: building a heap takes O(K) time for K+1 elements. Insertion into and extraction from the min-heap take O(log(K)), each. Across all three loops, we do at least one of these actions N times, so the total time complexity is O(N⋅log(K)). if K is substantially smaller than N, then we can consider log(K) constant and argue that the complexity is practically linear.

Space Complexity: we need to a maintain min-heap of size K+1 throughout the algorithm, so the auxiliary space complexity is O(K).
 */

public class KMessedArray {
	
	static int[] sortKMessedArray(int[] arr, int k) {
	    
	    PriorityQueue<Integer> queue = new PriorityQueue<>();
	    
	    for(int i=0; i<k+1; i++){
	      queue.add(arr[i]);
	    }
	    // your code goes here
	    
	    int index=0;
	    
	    for(int i=k+1; i< arr.length; i++){
	      arr[index] = queue.poll();
	      queue.add(arr[i]);
	      index++;
	     
	    }
	    
	   while(!queue.isEmpty()){
	     arr[index++] = queue.peek();
	     queue.poll();
	   }
	    
	    return arr;
	   
	  }

	  public static void main(String[] args) {
	int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
	    int k = 2;
	    sortKMessedArray(arr , k);
	    
	    for(int i=0; i<arr.length; i++){
	      System.out.println(arr[i]);
	    }
	    
	  }


}
