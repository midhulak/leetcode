package com.snc.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
public int[][] merge(int[][] intervals) {
        
        
        if(intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0] , i2[0]));
        
        List<int[]> result = new ArrayList<>();
        
        int[] newInterval = intervals[0];
        result.add(newInterval);
    // [1 5 ]    [2 4]
        for(int[] interval : intervals){
            //if next start time less tahn previous end time
            if(interval[0] <= newInterval[1])
                newInterval[1] = Math.max(interval[1] , newInterval[1]);
            
            else{
                newInterval = interval;
                result.add(newInterval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
