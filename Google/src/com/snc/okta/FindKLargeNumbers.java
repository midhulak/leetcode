package com.snc.okta;

import java.util.PriorityQueue;

public class FindKLargeNumbers {
	
	 public int findKthLargest(int[] nums, int k) {
	        
	       // PriorityQueue<Integer> q = new PriorityQueue<>( (a , b) -> (b - a)); //kth smallest number
	         PriorityQueue<Integer> q = new PriorityQueue<>();  //kth laregst number
	        int res=0;
	        
	        for(int i=0; i<nums.length; i++){
	             q.add(nums[i]);
	            if(q.size() > k){
	                q.poll();
	           
	            }
	            
	                
	            
	        }
	        
	       System.out.println(q.peek());
	        return q.peek();
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
