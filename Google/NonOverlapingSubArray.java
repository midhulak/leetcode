package Google;
import java.util.*;
public class NonOverlapingSubArray {
	/*greedily by picking the first shortest subarray you encounter. 
	 * This part is easier than the original question. 
	 * Then you only need to check if that subarray overlaps with the previous subarray. 
	 * Runtime: we check one pair of intervals at most per each element of the array O(n).
	 */
	public static int subarraySumOverlap(int[]arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int result = 0;
		int last = -1;
		int runningSum = 0;
		for(int i = 0; i < arr.length; i++) {
			runningSum += arr[i];
			if(map.containsKey(runningSum - k) && map.get(runningSum - k) + 1 > last) {
				result++;
				last = i;
			}
			map.put(runningSum, i);
		}
		return result;
	}
	public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	public static void main(String[]args) {
		int[]arr = {1, 1, 1};
		System.out.println(subarraySumOverlap(arr, 2));
		System.out.println(subarraySum(arr, 2));
	}
}
