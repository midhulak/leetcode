package com.strings;

import java.util.Arrays;

public class LongestIncresingSubSequence {

public int lengthOfLIS(int[] nums) {
        
        int[] lis = new int[nums.length];
        Arrays.fill(lis , 1);
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                
                if(nums[i] > nums[j] && lis[i] < lis[j]+1){
                    
                        lis[i] = lis[j]+1;
                }
            }
        }
        
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0; i<lis.length; i++){
            
            if(lis[i] > max)
                max = lis[i];
        }
        
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
