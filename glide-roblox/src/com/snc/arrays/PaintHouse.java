package com.snc.arrays;

public class PaintHouse {

	/*https://leetcode.com/problems/paint-house/submissions/ */
	//https://leetcode.com/problems/paint-house/submissions/
	
	  public int minCost(int[][] costs) {
	        
	        if(costs.length == 0 || costs == null)
	            return 0;
	        
	        for(int i=1; i<costs.length; i++){
	            //no two houses have same color so what color we are paintiung this house get the minimum of other 2 colors from previous house.
	            costs[i][0] += Math.min(costs[i-1][1] , costs[i-1][2]);
	            costs[i][1] += Math.min(costs[i-1][0] , costs[i-1][2]);
	            costs[i][2] += Math.min(costs[i-1][0] , costs[i-1][1]);
	            
	         }
	        return Math.min( Math.min(costs[costs.length-1][0] , costs[costs.length-1][1]) , costs[costs.length-1][2] );
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
