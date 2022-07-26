package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkyLineProblem {
	
	 public List<List<Integer>> getSkyline(int[][] buildings) {
	        List<List<Integer>> result = new ArrayList<>();
	        List<int[]> height = new ArrayList<>();
	        //mark start and end points of each building
	        for (int[] b : buildings) {
	            height.add(new int[]{b[0], -b[2]});
	            height.add(new int[]{b[1], b[2]});
	        }
	        
	       
	        //mark all consequtive building sby sorting with x axis
	        Collections.sort(height, (a, b) -> {
	            if (a[0] != b[0])
	                return a[0] - b[0];
	            return a[1] - b[1];
	        });
	        
	        //We need to get max y value and whenever height changes and if it start point we nee dto add to priority queu and get maxVal if  we need to add to priority queue and if maxvalue changes then add it to our result.
	        //if it is end need to remove from priority queue an dagain same maxvalue changes add it to prioruty queue.
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
	        pq.offer(0);
	        int prev = 0;
	        for (int[] h : height) {
	            if (h[1] < 0) {
	                pq.offer(-h[1]);
	            } else {
	                pq.remove(h[1]);
	            }
	            int cur = pq.peek();
	            if (prev != cur) {
	                List<Integer> tmp = new ArrayList<>();
	                tmp.add(h[0]);
	                tmp.add(cur);
	                result.add(new ArrayList<>(tmp));
	                prev = cur;
	            }
	        }
	        return result;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
