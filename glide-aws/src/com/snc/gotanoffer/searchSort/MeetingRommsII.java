package com.snc.gotanoffer.searchSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRommsII {
	/**
	 * Time Complexity: O(N\log N)O(NlogN).

There are two major portions that take up time here. One is sorting of the array that takes O(N\log N)O(NlogN) considering that the array consists of NN elements.
Then we have the min-heap. In the worst case, all NN meetings will collide with each other. In any case we have NN add operations on the heap. In the worst case we will have NN extract-min operations as well. Overall complexity being (NlogN)(NlogN) since extract-min operation on a heap takes O(\log N)O(logN).
Space Complexity: O(N)O(N) because we construct the min-heap and that can contain NN elements in the worst case as described above in the time complexity section. Hence, the space complexity is O(N)O(N).

	 * @author midhula.kadiyala
	 *
	 */
	
	 class Comp implements Comparator<int []> {
	        public int compare(int [] a, int [] b) {
	            if(a[0] < b[0]) {
	                return -1;
	            } else if (a[0] > b[0] ) {
	                return 1;
	            } else {
	                return 0;
	            }
	        }
	    }
	    public int minMeetingRooms(int[][] intervals) {
	        if(intervals.length == 0)
	            return 0;
	        Arrays.sort(intervals, new Comp());
	        Queue<Integer> pq = new PriorityQueue<>();
	        pq.offer(intervals[0][1]);
	        for (int i =1; i<intervals.length; i++) {
	            if(intervals[i][0] >= pq.peek()) {
	                pq.poll();
	            }
	            pq.offer(intervals[i][1]);
	        }
	        return pq.size();
	    }
	    
	    
//	  //allocating rooms and storing in map for its satrt time and end time,a nd while any meeting interval checking in the map if starttime is greater than meeting end time and allocating taht room to them and updating teh map.
//	    static class Room{
//	    
//	        int start;
//	        int end;
//	        
//	        Room(){
//	            this.start = start;
//	            this.end = end;
//	        }
//	    }
//	    
//	    public int minMeetingRooms(int[][] intervals) {
//	        
//	        if(intervals.length == 0)
//	            return 0;
//	        Arrays.sort(intervals , (i1,i2) -> Integer.compare(i1[0] , i2[0])); //sort by starting times
//	        // 2,4.  7,10
//	        
//	     
//	        Map<Integer , Room> map = new HashMap<Integer , Room>(); //storing rooms in a map and it's start time and end time
//	      
//	        for(int i=0; i<intervals.length; i++){
//	            boolean roomFound = false;
//	            for(Map.Entry<Integer , Room> roomMap : map.entrySet()){
//	                 Room r = roomMap.getValue();
//	                 
//	                if(intervals[i][0] >= r.end ){
//	              Room room = new Room();
//	       room.start = intervals[i][0];
//	        room.end = intervals[i][1];
//	                    map.put(roomMap.getKey(), room);
//	                    roomFound=true;
//	                    break;
//	                }
//	                    
//	                
//	            }
//	            
//	            if(!roomFound){
//	                    Room room = new Room();
//	       room.start = intervals[i][0];
//	        room.end = intervals[i][1];
//	                map.put(map.size()+1 , room);
//	            }
//	                
//	        }
//	            
//	            return map.size();
//	        }
//	        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
