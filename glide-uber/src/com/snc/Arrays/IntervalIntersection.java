package com.snc.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
Medium

3972

82

Add to List

Share
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 
 * @author midhula.kadiyala
 *
 */
public class IntervalIntersection {
	
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
		int a=0,b=0;
		
		
		while(a < A.length && b < B.length) {
			int[] newResult= new int[2];
			newResult[0]=Math.max(A[a][0], B[b][0]);
			newResult[1]=Math.min(A[a][1], B[b][1]);
			if(newResult[0] <= newResult[1]) {
			System.out.println("{"+newResult[0]+","+newResult[1]+"}");
			result.add(newResult);
			}
			
			if(A[a][1] < B[b][1]) 
				a++;
			else
				b++;
			
		}
		
		
		
		return result.toArray(new int[result.size()][]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
