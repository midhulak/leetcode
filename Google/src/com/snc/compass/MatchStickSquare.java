package com.snc.compass;

import java.util.Arrays;

public class MatchStickSquare {
	
    public boolean makeSquare(int[] matchSticks) {
    	
    	if(matchSticks.length < 4)
    		return false;
    	int perimeter=0;
    	
    	for(int i : matchSticks) {
    		perimeter+=i;
    	}
    	
    	if(perimeter %4 != 0)
    		return false;
    	
    int side = perimeter/4;
    
    int[] sides = new int[4];
    Arrays.fill(sides, side);
    
    return squareHelper(matchSticks , sides , 0);
    }
    
    public static boolean squareHelper(int[] matchSticks , int[] sides , int i) {
    	
    	if(i == matchSticks.length) 
    	return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
    	
    	
    	for(int j=0 ; j<4; j++) {
    		
    		if(matchSticks[i] > sides[j])
    			continue;
    		sides[j]-=matchSticks[i];
    		
    		if(squareHelper(matchSticks , sides , i+1))
    				return true;
    		sides[j]+=matchSticks[i];
    	}
    	return false;
    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
