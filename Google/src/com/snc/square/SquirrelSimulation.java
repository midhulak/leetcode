package com.snc.square;

public class SquirrelSimulation {
	
	/**
	 * 
	 * 
	 * @param args
	 */
	
	public int minDistance(int height , int width , int[] tree , int[] squirrel , int[][] nuts) {
		
		int sum=0;
		for(int[] nut : nuts) {
			int diffTreeRowTonutRow = Math.abs(nut[0] - tree[0]);
			int diffTreeColTonutCol = Math.abs(nut[1] - tree[1]);
			sum+=diffTreeRowTonutRow+diffTreeColTonutCol;
		}
		
		/** if squirrel is under teh tree each time it goes to nut and get back to tree as I have already
		 *  calculated the distance of each nut to tree an di need to twice teh sum for returning back
		 * 
		 */
		
		if(tree[0] == squirrel[0] && tree[1] == squirrel[1]) {
			return 2*sum;
		}
		
		int result = Integer.MAX_VALUE;
		
		/* need to go squirel located then need to go nut an dplace it into tree and traverse the places where all nuts present
		 * 
		 */
		
		for(int i=0 ; i<nuts.length; i++) {
			
			int diffSrowtoNutrow = Math.abs(squirrel[0] - nuts[i][0]);
			int diffScoltoNutcol = Math.abs(squirrel[1] - nuts[i][1]);
			
			//now squirrel reached nut and then see distance from that particular nut to tree 
			
			int nutToTreeRow = Math.abs(nuts[i][0] - tree[0]);
			int nutToTreeCol = Math.abs(nuts[i][1] - tree[1]);
			
			result = Math.max(result  , 2*sum+diffSrowtoNutrow+diffScoltoNutcol -(nutToTreeRow+nutToTreeCol));
		}
		 
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
