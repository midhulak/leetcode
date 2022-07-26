package com.snc.arrays.strings;

public class ContainerWithMostWater {
	
	//area is how far the poles have max lengths with most water
//	
//	Time complexity: O(n)O(n). Single pass.
//
//	Space complexity: O(1)O(1). Constant space is used.
	
	 //brute force
    public int maxArea1(int[] height) {
        
        //checking brute force for each pillar compare to all pillars from left and checking teh max area..
        
        int res=0;
        
        for(int i=0 ; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                
                int area = (j-i) * Math.min(height[i] , height[j]);
                res=Math.max(res,area);
            }
        }
        return res;
    }
    
    
     public int maxArea(int[] height) {
        
        //checking brute force for each pillar compare to all pillars from left and checking teh max area..
        
        int res=0;
        
        int left=0;
         int right=height.length-1;
         
         while(left < right){
             
             int area = (right-left)* Math.min(height[left] , height[right]);
             res=Math.max(res,area);
             
             if(height[left] < height[right])
                 left++;
             
             else
                 right--;
             
         }
         return res;
    }
}
