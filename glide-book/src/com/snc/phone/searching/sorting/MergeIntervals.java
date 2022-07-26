package com.snc.phone.searching.sorting;
/*
 *   Title: Merge intevals
 *
 *   Problem: Given a collection of intervals, merge all overlapping intervals.
 *
 *   Execution: javac MergeIntervals.java && java MergeIntervals
 */
import java.util.*;
import java.util.Arrays;

/*
 * 1. Merge Intervals
a. Time Complexity
i. We are computing every possible time slice
ii. At each time slice, we have to look at all of our intervals
iii. Take T as the total range of times of all the interviews
iv. Take n as the number of intervals
v. O(T*n)
b. Space Complexity
i. We are creating a boolean array of length T ii. O(T)
c. Best Conceivable Runtime
i. We have to iterate over the input itself at the very least
ii. O(n)
d. Best Conceivable Space
i. There is no necessary reason for us to use any space
ii. We don’t count the space allocated for the result of our function
iii. O(1)
e. Optimization approaches
i. We don’t really need to look at all the time slices. We can just look at the start and end of each interval
ii. Would it help us to sort the intervals somehow?
iii. What does it actually mean for 2 intervals to be overlapping? The start of
the one interval is between the start and end of the other interval
iv. Do you have to merge the intervals in any particular order?
f. Plain-English solution
 i. ii.
First, let’s sort the intervals by start time
Now iterate over all of the intervals and merge them together
1. Take the first interval and see if it overlaps with the second interval
2. If so, see if that combined interval overlaps with the third interval
3. When you find that the next interval doesn’t overlap, save the
previous merged interval to your result array
 */

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
		int[] newInterval = intervals[0]; //[1 4] [3,5]
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
        int[][] testIn_1 = { { 1, 3 }, { 2, 6 }, {8, 10}, {15, 18} };
        int[][] testOut_1 = { {1, 6}, {8, 10}, {15, 18} };
        
       int[][] result = mergeIntervals(testIn_1);
       
       for(int i=0 ; i< result.length ; i++) {
    	   System.out.println("result is="+"["+result[i][0]+ "," + result[i][1]+"]" );
       }
//        assert Arrays.equals(mergeIntervals(testIn_1), testOut_1);
//        System.out.println("Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].");
//
//        int[][] testIn_2 = { { 1, 4 }, {4, 5} };
//        int[][] testOut_2 = { {1, 5} };
//        assert Arrays.equals(mergeIntervals(testIn_2), testOut_2);
//        System.out.println("Explanation: Intervals [1,4] and [4,5] are considered overlapping.");
//
//
//        System.out.println("Passed all test cases");
    }
    
}