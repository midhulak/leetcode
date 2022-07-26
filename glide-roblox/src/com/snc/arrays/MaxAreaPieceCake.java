package com.snc.arrays;

import java.util.Arrays;

public class MaxAreaPieceCake {
	
	
	/**
	 * You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

 
	 * @param h
	 * @param w
	 * @param horizontalCuts
	 * @param verticalCuts
	 * @return
	 */
	
	 public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
	        
	        
	        //sort the arrays
	        Arrays.sort(horizontalCuts);
	        Arrays.sort(verticalCuts);
	        
	        
	        //horizon   0 [1,2,4] 5.  //5 rows diff of 0 to 1 =1 1 to 2 is 1 and 2 to 4 is 2 and 4 to 5 is 1 //max is 2
	        //vert.    0 [1 3] 4 //4 cols   diff of 0 to 1 is 1 and 1 to 3 is 2 and 3 to 4 is 1 and max is 2
	        
	        //horizon max * vertical max is 2*2 = 4
	         
	        long horMax =horizontalCuts[0]-0;
	        long verMax = verticalCuts[0]-0;
	        
	        for(int i=0; i<horizontalCuts.length-1; i++){
	            
	            horMax = Math.max(horMax , horizontalCuts[i+1] - horizontalCuts[i]);
	        }
	        
	        for(int j=0; j<verticalCuts.length-1; j++){
	            verMax = Math.max(verMax , verticalCuts[j+1]-verticalCuts[j]);
	        }
	        
	       horMax = Math.max(horMax , h-horizontalCuts[horizontalCuts.length-1]);
	                    
	        verMax = Math.max(verMax , w-verticalCuts[verticalCuts.length-1]);
	        
	      return (int)((horMax*verMax) % 1000000007);
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
