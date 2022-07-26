package com.snc.arrays;

import java.util.Arrays;

/**
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.


 * @author midhula.kadiyala
 *
 */

public class MaxUnitsTruck {
	
	 public int maximumUnits(int[][] boxTypes, int truckSize) {
	     Arrays.sort(boxTypes , (i1,i2)->Integer.compare(i2[1] , i1[1]));
	        int totUnits=0;
	        
	        if(truckSize == 0)
	            return 0;
	        
	        //sort based on units
	        
	        int i=0;
	        
	        while(truckSize > 0 && i < boxTypes.length){
	            
	            if(boxTypes[i][0] <= truckSize){
	                truckSize-=boxTypes[i][0];
	                totUnits+= boxTypes[i][0] * boxTypes[i][1];

	                
	            }
	            
	            else{
	                totUnits += truckSize * boxTypes[i][1];
	                truckSize=0;
	                
	            }
	                
	            i++;
	        }
	        
	        return totUnits;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
