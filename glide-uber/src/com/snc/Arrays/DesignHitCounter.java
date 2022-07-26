package com.snc.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
	  /** Initialize your data structure here. */
    Queue<Integer> queue = null;
    public DesignHitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
        queue.offer(timestamp);
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        while(!queue.isEmpty() && (timestamp - queue.peek()) >= 300){
            queue.poll();
        }
        
        return queue.size();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
