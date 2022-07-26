package com.snc.leetcodechallenges.feb;

public class WaterAreaPerimeter {
	
	int res=0;
	
	public static int waterArea(int[] height) {
		int res=0;
		
		for(int i=0 ; i<height.length; i++) {
			for(int j=i+1 ; j<height.length; j++) {
				
				int area = (j-i) * Math.min(height[i], height[j]);
				
				res=Math.max(res , area);
						
			}
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(waterArea(height));
		
	}

}
