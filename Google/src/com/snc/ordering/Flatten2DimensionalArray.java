package com.snc.ordering;
import java.util.LinkedList;
import java.util.List;



/*
 * Function signature: List<List<Integer>> arrayOfArrays(int[][] arr)
eg.
arrayOfArrays({{1,2}, {3}, {4,5}}) =
{{1,3,4}, {1,3,5}, {2,3,4}, {2,3,5}}
 */

public class Flatten2DimensionalArray {
	 public static List<List<Integer>> arrayOfArrays(int[][] arr) {
		    List<List<Integer>> results = new LinkedList<List<Integer>>();
		    arrayOfArrays(arr, 0, new LinkedList<Integer>(), results);
		    return results;
		}
		private static void arrayOfArrays(int[][] arr, int i, List<Integer> path,
		                                  List<List<Integer>> results) {
		    if (i == arr.length) {
		        results.add(new LinkedList<Integer>(path));
		        return;
		}
		    for (int j : arr[i]) {
		        path.add(j);
		        arrayOfArrays(arr, i+1, path, results);
		        path.remove(path.size() - 1);
		    }
		}
	
}
