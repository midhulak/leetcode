package Google;

public class AllConsecutiveContiguosSubarray {
	public static int consecutiveContiguosSubarrayCount(int[]arr, int k) {
		int count = 0;
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == k) {
				count++;
			} else {
				count = 0;
			}
			ans += count;
		}
		return ans;
	}
	public static void main(String[]args) {
		int[]arr = {2, 2, 5, 6, 2, 2, 2};
		int k = 2;
		System.out.println(consecutiveContiguosSubarrayCount(arr, k));
	}
}
