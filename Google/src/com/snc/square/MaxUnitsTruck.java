package com.snc.square;

import java.util.Arrays;

public class MaxUnitsTruck {
	
	
	 public static int maximumUnits(int[][] boxTypes, int truckSize) {
	        Arrays.sort(boxTypes , (i1,i2)->Integer.compare(i2[1] , i1[1]));
	        
	      // [10,45]  truckSize=7 
	        int maxCount=0;
	        
	       for(int i=0; i < boxTypes.length; i++){
	           
	           if(truckSize > 0){
	           truckSize = truckSize - boxTypes[i][0];
	           
	           if(truckSize < 0){
	               maxCount+= (boxTypes[i][0]-Math.abs(truckSize)) * boxTypes[i][1];
	           }
	           else
	           maxCount+= boxTypes[i][0] * boxTypes[i][1];
	           
	         
	       }
	        
	    }
	        return maxCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] boxTypes = { {5,10} ,{2,5} ,{4,7} ,{3,9}};
		int truckSize = 10;
		
		maximumUnits(boxTypes , truckSize);

	}

}
