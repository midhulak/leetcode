package com.snc.arrays.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * et NN be the length of the input array.

Time complexity : O(N)O(N).

This is because we are only iterating over the array once, and at each step, we're performing O(1)O(1) operations. We treat the string building as O(1)O(1) because the strings can never be more than a fixed size.

Space complexity : O(1)O(1).

The output list has a worst case size of O(N)O(N). This case occurs when we have a missing range between each of the consecutive elements in the input array (for example, if the input array contains all even numbers between lower and upper). We aren't using any other additional space, beyond fixed-sized constants that don't grow with the size of the input.
 * @author midhula.kadiyala
 *
 */

public class FindMissingRanges {
	
	   public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	        long l = (long) lower;
	        long u = (long) upper;
	        List<String> res = new ArrayList<>();
	        int n = nums.length;

	        if (n == 0) {
	            add(res, l - 1, u + 1);
	            return res;
	        }
	//need to take acre of first term
	        add(res, l - 1, nums[0]);
	        for (int i = 1; i < n; i++) {
	            add(res, nums[i - 1], nums[i]);
	        }
	        //need to take care of last term.
	        add(res, nums[n - 1], u + 1);
	        return res;
	    }

	    private void add(List<String> res, long lo, long hi) {
	        if (lo == hi) {
	            return;
	            //consequtive number means no missing element
	        } else if (lo + 1 == hi) {
	            return;
	            //exactly 1 number missing
	            //if we add +1 to current number and taht is equal to nextnumber-1 taht means exactly 1 number is missing
	            //for eg 5, 7. 
	            //add 1 to 5 i.e 6 and remove 1 from 7 i.e 6 and 6 eqal to 6 so exactly 1 missing number between 5 to 7
	        } else if (lo + 1 == hi - 1) {
	            res.add(String.valueOf(lo + 1));
	        } 
	        //if lot of numbers missing then adding range to the list lo+1 and hi-1
	        else {
	            StringBuilder sb = new StringBuilder();
	            sb.append(String.valueOf(lo + 1));
	            sb.append("->");
	            sb.append(String.valueOf(hi - 1));
	            res.add(sb.toString());
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
