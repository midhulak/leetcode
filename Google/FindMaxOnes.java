package Google;

public class FindMaxOnes {
	/*consider every 0 as -1 and every 1 as 1, find the sum of largest subarray sum in this modified array. 
	 * This sum is our required max_diff ( count of 1s – count of 0s in any subarray). 
	 * Finally we return the max_diff plus count of zeros in original array.
	 * Time : O(n)
	 */
	public static int findMaxOnesCount(int arr[], int n) {
        // Initialize count of zeros and maximum difference
        // between count of 1s and 0s in a subarray
        int onesCount = 0;
      
        // Initiale overall max diff for any subarray
        int maxDiff = 0;
      
        // Initialize current diff
        int currMax = 0;
      
        for (int i = 0; i < n; i ++) {
            // Count of zeros in original array (Not related
            // to Kadane's algorithm)
            if (arr[i] == 1)
            	onesCount ++;
            int val = 0;
            // Value to be considered for finding maximum sum
            if(arr[i] == 0){
            	val = 1;
            } else {
            	val = -1;
            }
      
            // Update current max and max_diff
            currMax = Math.max(val, currMax + val);
            maxDiff = Math.max(maxDiff, currMax);
        }
        maxDiff = Math.max(0, maxDiff);
      
        return onesCount + maxDiff;
    }
	/*question is related to sub array the Kadane's algorithm is very useful. 
	 * The real problem in this question is to find largest contiguous sub array 
	 * for which difference 'numberOfZeros - numberOfOnes' is the biggest to maximize the sum of ones after flipping zeros.
		Here is modified version of Kadane's algorithm to do this job.
		It converts 0 to -1 and computes the sum till the sum is <=0 (there is more 0s then 1s).
		If the sum is > 0 starts from the beginning.
		The major difference compare to ordinary Kadane's algorithm is that we are looking for 
		the biggest negative sum instead of positive.
		time : O(n) space : O(1)
		*/
	public static void flipBits(int[] a) {

		int maxDiff = 0;
		int flipStartIndex = 0;
		int flipEndIndex = 0;
		int onesToFlip = 0;
		int totalNumberOfOnes = 0;

		int currentDiff = 0;
		int currentStart = 0;
		int currentOnesToFlip = 0;

		for (int i = 0; i < a.length; i++) {
		    if (a[i] == 0) {
				currentDiff -= 1;
		    } else {
				currentDiff += 1;
				currentOnesToFlip++;
				totalNumberOfOnes++;
		    }
		    if (currentDiff < maxDiff) {
				maxDiff = currentDiff;
				flipStartIndex = currentStart;
				flipEndIndex = i;
				onesToFlip = currentOnesToFlip;
		    } else if (currentDiff > 0) {
				currentDiff = 0;
				currentStart = i + 1;
				currentOnesToFlip = 0;
		    }
		}
		System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);
	} 
	//After we flipped atmost k
	//https://leetcode.com/problems/max-consecutive-ones-iii/
	
    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 0, 1, 1, 0};
         
        System.out.println(findMaxOnesCount(arr, arr.length));
        flipBits(arr);
    }
}
