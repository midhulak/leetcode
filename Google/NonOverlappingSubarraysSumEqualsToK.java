package Google;

import java.util.HashMap;
import java.util.Map;

/*greedily by picking the first shortest subarray you encounter. 
This part is easier than the original question. 
Then you only need to check if that subarray overlaps with the previous subarray. 
Runtime: we check one pair of intervals at most per each element of the array O(n).*/

public class NonOverlappingSubarraysSumEqualsToK {
	public static int subArraySum(int[]arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,  -1);
		int result = 0;
		int sum = 0;
		int last = -1;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(map.containsKey(sum - k) && map.get(sum - k) + 1 > last) {
				result++;
				last = i;
			}
			map.put(sum, i);
		}
		return result;
	}
	public static void main(String[]args) {
		int[]arr = {-1,-2,8,-3,8,-5,5,-4,5,4,1};
		int k = 5;
		System.out.println(subArraySum(arr, k));
	}
}
