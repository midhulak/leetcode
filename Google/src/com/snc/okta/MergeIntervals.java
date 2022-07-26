package com.snc.okta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static int[][] mergeIntervals(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		
/*compare the zero index of second array is less than first index of first ar
 * ray if it is true then get max nmber of first index of firstarray and first index of second array
 */
		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
	
	 public int eraseOverlapIntervals(int[][] intervals) {
	        //sort it based on second index in ascending order..
	        
	        //and take first index second col is ending number and just iterate if any index is less than end means it is overlapping.
	        //for eg: [[1,2],[2,3],[3,4],[1,3]]
	        //if sort it then [[1,2],[2,3],[1,3], [3,4]]
	        //first end is 2 then will check next elements any start is less than end if it is then it is overlapping else newend will be second col
	        // in above exampel 1,3 and 1 is less than 2 and 1,3 is overlapping between 1,2 and 2,3 so it shud be removed.
	        if(intervals.length == 0)
	            return 0;
	        
	        Arrays.sort(intervals, (i1,i2) -> i1[1] - i2[1]);
	        
	        int end = intervals[0][1];
	        int count=0;
	        
	        for(int i=1 ; i < intervals.length; i++){
	            
	            if(intervals[i][0] < end)
	                count++;
	            else
	                end = intervals[i][1];
	            
	        }
	        return count;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
