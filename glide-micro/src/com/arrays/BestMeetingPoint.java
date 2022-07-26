package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {
	
	 public int minTotalDistance(int[][] nums) {
	        
	        //get all x cordinates
	        //get all y cordinates
	        //sort x cordinates and find the median
	        //sort y cordinates and find median
	        //then add   the diff between xmed to all xcordinates
	        //then add the diff between ymed to all ycordinates
	         List<Integer> xCord = new ArrayList<>();
	        
	        List<Integer> yCord = new ArrayList<>();
	        
	        
	        for(int i=0; i<nums.length; i++){
	            for(int j=0; j<nums[0].length; j++){
	                
	                if(nums[i][j] == 1)
	                    xCord.add(i);
	            }
	        }
	        
	        
	          for(int i=0; i<nums[0].length; i++){  
	            for(int j=0; j<nums.length; j++){
	                
	                if(nums[j][i] == 1)
	                    yCord.add(i);
	            }
	        }
	        
	        
	        int xMed = xCord.get(xCord.size()/2);
	        int yMed = yCord.get(yCord.size()/2);
	        
	         
	       return distanceFromTwoCordinates(xCord , xMed) + distanceFromTwoCordinates(yCord , yMed);
	        
	    }
	    
	    
	    public int distanceFromTwoCordinates(List<Integer> list , int cord){
	        int distance=0;
	        
	        for(Integer i : list){
	            distance+=Math.abs(i-cord);
	        }
	        
	        return distance;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
