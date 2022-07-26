package com.snc.arrays;

import java.util.Arrays;

public class BoatsToSavePeople {
	
	/**
	 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.
	 * @param people
	 * @param limit
	 * @return
	 */
	
	 public int numRescueBoats(int[] people, int limit) {
	        
		//hint boat carries atmost 2 people max if weight limit if weight of those people is atmost limit
		        
		    Arrays.sort(people);
		        //sort the pople weight so that lightest people weight will be left and heaveier people weight on right
		        //try to combine lighter with heavier see if it is <= limit then carry otherwise just take the heavier people nad decrement right pointer
		        
		        int left=0;
		        int right=people.length-1;
		        int numofboats=0;
		        
		        while(left <= right){
		            
		            if(people[left] + people[right] <= limit)
		            {
		                left++;
		                right--;
		            }
		            else{
		                right--;
		            }
		            
		            numofboats++;
		        }
		        
		        return numofboats;
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
