package com.snc.okta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeetingRooms {
	
	//check all meeting rooms in leetcode
	//merge intervals
	//meeting scheduler
	
	 static class Room{
		    
	        int start;
	        int end;
	        
	        Room(){
	            this.start = start;
	            this.end = end;
	        }
	    }
	    
	  public boolean canAttendMeetings(int[][] intervals) {
	        
		    if(intervals.length == 0 || intervals.length == 1)
		        return true;
		        
		        Arrays.sort(intervals ,(i1,i2) -> Integer.compare(i1[0] , i2[0]));
		        
		        
		        for(int i=1 ; i<intervals.length; i++){
		            
		          
		            
		            if(intervals[i-1][1] > intervals[i][0])
		                return false;
		        }
		        return true;
		    }
	 
	    public int minMeetingRooms(int[][] intervals) {
	        
	        if(intervals.length == 0)
	            return 0;
	        Arrays.sort(intervals , (i1,i2) -> Integer.compare(i1[0] , i2[0])); //sort by starting times
	        // 2,4.  7,10
	        
	     
	        Map<Integer , Room> map = new HashMap<Integer , Room>(); //storing rooms in a map and it's start time and end time
	      
	        for(int i=0; i<intervals.length; i++){
	            boolean roomFound = false;
	            for(Map.Entry<Integer , Room> roomMap : map.entrySet()){
	                 Room r = roomMap.getValue();
	                 
	                if(intervals[i][0] >= r.end ){
	              Room room = new Room();
	       room.start = intervals[i][0];
	        room.end = intervals[i][1];
	                    map.put(roomMap.getKey(), room);
	                    roomFound=true;
	                    break;
	                }
	                    
	                
	            }
	            
	            if(!roomFound){
	                    Room room = new Room();
	       room.start = intervals[i][0];
	        room.end = intervals[i][1];
	                map.put(map.size()+1 , room);
	            }
	                
	        }
	            
	            return map.size();
	        }
	        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
