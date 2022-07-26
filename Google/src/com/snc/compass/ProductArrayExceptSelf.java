package com.snc.compass;

public class ProductArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] answer = new int[len];
        
        
        left[0] = 1;
        
        for(int i=1 ; i<len ; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        right[len-1] = 1;
        
        for(int i=len-2 ; i>=0 ; i--){
            right[i] = right[i+1]*nums[i+1];
        }
        
        for(int i= 0 ; i<len;i++){
            answer[i] = left[i]*right[i];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
