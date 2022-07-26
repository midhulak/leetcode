package com.snc.Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMeetingRooms {
	
public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals , (i1,i2)->Integer.compare(i1[0] , i2[0]));
        
      Queue<Integer> pq = new PriorityQueue<>();
        
        pq.offer(intervals[0][1]);
        
        
        for(int i=1; i<intervals.length; i++){
            
        
            if(intervals[i][0] >= pq.peek() )
                pq.poll();
            
            pq.offer(intervals[i][1]);
            
        }
        
        return pq.size();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
