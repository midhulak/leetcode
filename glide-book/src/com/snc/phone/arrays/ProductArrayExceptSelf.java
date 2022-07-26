package com.snc.phone.arrays;

public class ProductArrayExceptSelf {
	
	/**
	 * https://leetcode.com/problems/product-of-array-except-self/
    Time complexity : O(N) where N represents the number of elements in the input array. We use one iteration to construct the array LL, one to construct the array RR and one last to construct the answeranswer array using LL and RR.
Space complexity : O(N)O(N) used up by the two intermediate arrays that we constructed to keep track of product of elements to the left and right.

*/
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] answer = new int[len];
        
        
        left[0] = 1;
        //just calculating multiplication till left hand side by leaving that number
        for(int i=1 ; i<len ; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        right[len-1] = 1;
        //same thing do it for right hand side 
        for(int i=len-2 ; i>=0 ; i--){
            right[i] = right[i+1]*nums[i+1];
        }
        //finally multiply those two arrays
        
        for(int i= 0 ; i<len;i++){
            answer[i] = left[i]*right[i];
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
