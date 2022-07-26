package com.snc.affirm;

public class TappingRainWater {
	
	public int trap(int[] heights) {
        int[] maxes = new int[heights.length];
        int leftMax=0;
        
//         0,1,0,2,1,0,1,3,2,1,2,1
            
//             0,0,1,1,2,2,2,2,2,3,3,3,
        for(int i=0; i<heights.length; i++){
            
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax=Math.max(leftMax , height);
        }
        
        int rightMax=0;
        int total=0;
        
        for(int i=heights.length-1; i>=0; i--){
            int height = heights[i];
            int minHeight = Math.min(rightMax , maxes[i]);
            
            if(height < minHeight){
                
                maxes[i] = minHeight - height;
                total+=maxes[i];
            }
            else{
                maxes[i]=0;
            }
            
            rightMax=Math.max(rightMax , height);
            
        }
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
