package com.snc.searching.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	//https://www.youtube.com/watch?v=FuLfL_WhUHI
	public int[][] insert(int[][] intervals, int[] newInterval) {
        
	      List<int[]> result = new ArrayList();
	        int i=0; int n = intervals.length;
	        //checking if ending time is less than start time of new interval  then we are good to that in result
	        while(i < n && intervals[i][1] < newInterval[0]){
	            result.add(intervals[i]);
	            i++;
	        }
	        int[] mergeIntervals = newInterval;
	        
	        //if start time of interval less than end time of an interval then taking min of start and max of end 
	        //try to overlap the intervals with merge intervals
	        while(i < n && intervals[i][0] <= mergeIntervals[1]){
	            mergeIntervals[0] =Math.min(intervals[i][0], mergeIntervals[0]);
	            mergeIntervals[1] =Math.max(intervals[i][1] , mergeIntervals[1]);
	            i++;
	        }
	        result.add(mergeIntervals);
	        
	        //trying to add rest.
	        while(i < n){
	            result.add(intervals[i]);
	            i++;
	        }
	        
	        return result.toArray(new int[result.size()][2]);
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
