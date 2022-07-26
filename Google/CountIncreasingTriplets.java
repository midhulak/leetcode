package Google;

public class CountIncreasingTriplets {
    private static int countTriplets(int[] nums) {
        int[] pos = new int[nums.length];
        for(int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }
        // first row - count of elements lesser than i-th element
        // second row - count of elements greater than i-th element
        int[][] leGr = new int[2][nums.length];
        sort(nums, pos, leGr, 0, nums.length - 1);
        int ans = 0;
        for(int j = 0; j < nums.length; j++) {
            ans += leGr[0][j] * leGr[1][j];
        }
        return ans;
    }

    private static void sort(int[] nums, int[] pos, int[][] leGr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, pos, leGr, lo, mid);
        sort(nums, pos, leGr, mid + 1, hi);
        merge(nums, pos, leGr, lo, mid, hi);
    }

    private static void merge(int[] nums, int[] pos, int[][] leGr, int lo, int mid, int hi) {
        int[] auxPos = new int[pos.length];
        for(int i = 0; i < pos.length; i++)
            auxPos[i] = pos[i];
        int i = lo, j = mid + 1, k = lo;

        while(i <= mid && j <= hi) {
            if (nums[pos[i]] < nums[pos[j]]) {
                leGr[1][pos[i]] += hi - j + 1;
                auxPos[k++] = pos[i++];
            } else {
                leGr[0][pos[j]] += i - lo;
                auxPos[k++] = pos[j++];
            }
        }

        while(i <= mid) {
            auxPos[k++] = pos[i++];
        }

        while(j <= hi) {
            leGr[0][pos[j++]] += i - lo;
        }

        System.arraycopy(auxPos, 0, pos, 0, pos.length);
    }

    public static void main(String[] args) {
    	int[]arr = {1, 2, 3, 4, 5};
    	System.out.println(countTriplets(arr));
//        CountIncreasingTriplets sol = new CountIncreasingTriplets();
//        assert sol.countTriplets(new int[1]) == 0;
//        assert sol.countTriplets(new int[]{5, 4, 3, 2, 1}) == 0;
//        assert sol.countTriplets(new int[]{1, 2, 3, 4, 5}) == 10;
//        assert sol.countTriplets(new int[]{3, 7, 1, 2, 10, 14, 2, 0, 1}) == 8;
//        assert sol.countTriplets(new int[]{9, 8, 7, 1, 2, 3, 8, 9}) == 11;
//        assert sol.countTriplets(new int[]{10, 9, 8, 7, 6, 1, 2, 3, 4, 5}) == 10;
//        assert sol.countTriplets(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}) == 14;
    }
}