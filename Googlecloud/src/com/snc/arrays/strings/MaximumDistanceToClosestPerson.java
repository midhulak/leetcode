package com.snc.arrays.strings;

public class MaximumDistanceToClosestPerson {
	
	//Tc: O(n) SC: O(1)
	
	/*https://www.youtube.com/watch?v=JtpGVqbiegQ&t=852s*/
	
	 public int maxDistToClosest(int[] seats) {
	        
		    //edges left and right and internal (consequtive zeros between 1's)
		        //get left most 1 and get the right most 1 indexes in idx1 and idx2 first set idx1=-1 and idx2 = -1
		        
		        //and if it is 1 update idx1 and idx2 and if it is empty incrfement empty ++ and whenever you encounter 1 then get the max distance between zeros using empty+1/2 
		        // suppos eif you get right most index at end of arary to get distance idx2-n-1 
		        
		        int empty=0;
		        int result=0;
		        int left=-1;
		        int right=-1;
		        int n = seats.length;
		            
		            int indexToSit = 0;
		            for(int i=0; i<seats.length; i++)
		            {
		                if(seats[i] ==1){
		                    empty=0;
		                    //updating index of right most every time, and  left most we update only once if it is -1
		                    if(left == -1)
		                        left=i;
		                    
		                        right=i;
		                }
		                    else{
		                        empty++;
		                        if((empty+1)/2 > result) {
		                        	indexToSit=i - (empty+1)/2;
		                        	result= Math.max(result , (empty+1)/2);
		                        }
		                      
		                    }
		                
		                
		                }
		            //from 0 index to right side how many seats far to seating position 
		            //and also from lastindex  to left sid ehow many seats far to seating position
		            
		            int cornerIndex=0;
		            
		            if(left >  n-1-right) {
		            	cornerIndex = left;
		            }
		            else
		            	cornerIndex = right;
		            
		            if(result < cornerIndex)
		            	indexToSit = cornerIndex;
		            
		           // return  indexToSit;   //if wanted to get which index to sit.
		        
		        return Math.max(result , Math.max(left , n-1-right));
		            }
		        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
