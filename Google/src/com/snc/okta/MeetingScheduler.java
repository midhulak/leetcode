package com.snc.okta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
	
	
	 public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
	        
	        if(slots1.length == 0 || slots2.length == 0)
	            return new ArrayList<Integer>();
	        
	        Arrays.sort(slots1 , (i1, i2) -> Integer.compare(i1[0] , i2[0]) );
	        Arrays.sort(slots2 , (i1, i2) -> Integer.compare(i1[0] , i2[0]) );
	        
	        int a = 0;
	        int b = 0;
	         
	        while(a < slots1.length && b < slots2.length){
	            
	            int lastStart = Math.max(slots1[a][0] , slots2[b][0]);
	            int firstEnd = Math.min(slots1[a][1] , slots2[b][1]);
	            
	            if( (firstEnd - lastStart) >= duration ){
	                
	               List<Integer> result = new ArrayList<Integer>();
	                
	                result.add(lastStart);
	                result.add(lastStart+duration);
	                
	                return result;
	            }
	            else{
	                if(slots1[a][1] == firstEnd)
	                    a++;
	                
	                if(slots2[b][1] == firstEnd)
	                    b++;
	                
	            }
	            
	        }
	        
	        return new ArrayList<Integer>();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] slots1 = { {10,50} , {60,120} , {140,210} };
		int[][] slots2 = { {0,15} , {60,70} };
		int duration = 8;
		
		minAvailableDuration(slots1 , slots2 , duration);
	}

}
