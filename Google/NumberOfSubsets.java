package Google;

import java.util.Arrays;
//O(n log n)
//space : O(1)
/*
  1. Sort nums so that we can use two pointers to represent a sorted range
    2. Search for ranges where nums[lo] + nums[hi] <= k
    3. Add all subsequences in that range - a list of length n has 2^n subsets
 */
public class NumberOfSubsets {
	public static void main(String[] args) {
        int[] nums1 = {2, 1, 3, 4};
        System.out.println(countSubsets(nums1, 8)); // 15

        int[] nums2 = {2, 4, 5, 7};
        System.out.println(countSubsets(nums2, 8)); // 5
    }
    
    public static int countSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            if (nums[low] + nums[high] > k) {
                high--;
            } else {
                count += 1 << (high - low); // count += pow(2, hi - lo) # or 1 << (hi - lo)

                low++;
            }
        }
        return count;
    }
}
