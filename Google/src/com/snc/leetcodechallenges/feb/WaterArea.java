package com.snc.leetcodechallenges.feb;

public class WaterArea {
	
	public static int waterArea(int[] heights) {
		
		int[] maxes = new int[heights.length];
		
		int leftMax=0;
		for(int i=0; i< heights.length; i++) {
			
			int height = heights[i];
			maxes[i]=leftMax;
			leftMax=Math.max(leftMax,height);
		}
		
		
		int rightMax=0;
		
		for(int i=heights.length-1; i>=0 ; i--) {
			int height = heights[i];
			int minHeight = Math.min(rightMax, maxes[i]);
			
			if(height < minHeight) {
				maxes[i] = minHeight-height;
			}
			else {
				maxes[i]=0;
			}
			rightMax=Math.max(rightMax,  height);
		}
		
		int total=0;
		for(int i=0 ; i<maxes.length; i++) {
			total+=maxes[i];
		}
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int[] heights = {1,8,6,2,5,4,8,3,7};
   System.out.println(waterArea(heights)); 

	}

}
