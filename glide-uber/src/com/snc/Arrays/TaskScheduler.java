package com.snc.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
	
	   //T O(n log 26) = O(n)
    //S O(26) = O(1)

//adding frequency and put in map and then add frequencies in priority queue..iterate priority queue until cool period each time iteration add time+= and i++ until cooling period and also everytime if priority queue is not top adding poll it and -1 and finally add ptemp to priority queue and repeat the process
public int leastInterval(char[] tasks, int n) {
      int[] freq = new int[26];
    
    for (char c: tasks) {
        freq[c - 'A']++;
    }
    
    //PQ maxheap
    PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
    
    for (int f : freq) {
        if (f > 0) {
            pq.offer(f);
        }
    }
    //resultant time interval
    int time = 0; 
    
    //iterate through pq until it is empty
    while (!pq.isEmpty()) {
        int i = 0;
        List<Integer> temp = new ArrayList<>();
        //iterate upto cooling period n
        while (i <= n) {
          
            if (!pq.isEmpty()) {
                
                if (pq.peek() > 1) {
                    //poll from pq
                    //add remaining freq instances to a temp ArrayList
                    temp.add(pq.poll() - 1);
                } else {
                    pq.poll();
                }
        
            }
            
            time++;
            
            //terminating condition for the loop
            if (pq.isEmpty() && temp.size() == 0) {
                break;
            }
            
            i++;
            
        }
        
        //add remaining instances of tasks accounted for back to the pq
        for (int t : temp) {
            pq.offer(t);
        }
    }
    
    return time;
    
   
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
