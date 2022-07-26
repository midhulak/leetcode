package Google;

import java.util.Random;

/*O(1) extra space and O(1) Time.
the first 0 - disp-1 index are the element which cannot be used, as they have appeared in last k calls.*/

class RandomArray {
	int [] nums;
	int k;
	int i = 0;
	Random r;
    // the use of disp is required as intially only 0 number is chosen,
    // so we are chosing a sliding window of max size disp.
    // the the max size of disp is K
	int disp = 0;
    RandomArray(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        r = new Random();
        int start =0;
    }
    public int getNum() {
        int index = r.nextInt(nums.length - disp);
        int chosenIndex = disp + index;
        int ans = nums[chosenIndex];
        swap(i, chosenIndex);
        disp = Math.min(k,disp +1);
        i = (i + 1)%k;
        return ans;
    }

    private void swap(int i, int j) {
        int temp =i;
        nums[i] = nums[j];
        nums[j] = temp;
    }
}