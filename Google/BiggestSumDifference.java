package Google;

public class BiggestSumDifference {
	//split arr into two parts negative and postive
	public static int sumDiff(int[]arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int[]postive = new int[arr.length];
		int[]negative = new int[arr.length];
		int j = 0;
		int k = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0) {
				postive[j] = arr[i];
				System.out.println("post :" + postive[j]);
				j++;
			} else {
				negative[k] = arr[i];
				System.out.println("neg :" + negative[k]);
				k++;
			}
		}
		int postiveprefixSum = prefixSum(postive);
		int postivesufixSum = suffixSum(postive);

		int negativeprefixSum = prefixSum(negative);
		int negtivesufixSum = suffixSum(postive);
		
		return sum;
		
	}
	public static int smallestSumSubarr(int arr[], int n) { 
          
        // to store the minimum value that is  
        // ending up to the current index 
        int min_ending_here = 2147483647; 
          
        // to store the minimum value encountered 
        // so far 
        int min_so_far = 2147483647; 
          
        // traverse the array elements 
        for (int i = 0; i < n; i++) { 
              
            // if min_ending_here > 0, then it could 
            // not possibly contribute to the  
            // minimum sum further 
            if (min_ending_here > 0) { 
                min_ending_here = arr[i];
            }
              
            // else add the value arr[i] to  
            // min_ending_here  
            else {
                min_ending_here += arr[i];
            }
              
            // update min_so_far 
            min_so_far = Math.min(min_so_far, 
                                   min_ending_here);          
        } 
          
        // required smallest sum contiguous  
        // subarray value 
        return min_so_far; 
    } 
	
	public static int maxSumArray(int[]arr) {
		int maxSum = arr[0];
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = Math.max(arr[i], arr[i] + sum);
			maxSum = Math.max(arr[i], maxSum);
		}
		return maxSum;
	}
	
	public static int prefixSum(int[]arr) {
		int prefixSum = 0;
		for(int i = 0; i < arr.length; i++) {
			prefixSum += arr[i]; 
		}
		return prefixSum;
	}
	
	public static int suffixSum(int[]arr) {
		int sufixSum = 0;
		for(int i = arr.length - 1; i >= 0; i--) {
			sufixSum += arr[i]; 
		}
		return sufixSum;
	}
	
	public static void main(String[]args) {
		int[]arr = {1, -1, 16, 2, -18};
		System.out.println(sumDiff(arr));
	}
}
