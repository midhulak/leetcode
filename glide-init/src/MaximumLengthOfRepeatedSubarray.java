import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumLengthOfRepeatedSubarray {
	
	// Given two integer arrays A and B, return the maximum length of an subarray
	// that appears in both arrays.
	//
	// Example 1:
	//
	// Input:
	// A: [1,2,3,2,1]
	// B: [3,2,1,4,7]
	// Output: 3
	// Explanation:
	// The repeated subarray with maximum length is [3, 2, 1].
	
	 /*
    Time Complexity: O((M + N) * \min(M, N) * \log{(\min(M, N))})O((M+N)∗min(M,N)∗log(min(M,N))), where M, NM,N are the lengths of A, B. The log factor comes from the binary search. The complexity of our naive check of a given \text{length}length is O((M+N) * \text{length})O((M+N)∗length), as we will create the seen strings with complexity O(M * \text{length})O(M∗length), then search for them with complexity O(N * \text{length})O(N∗length), and our total complexity when performing our check is the addition of these two.

Space Complexity: O(M^2)O(M 
2
 ), the space used by seen.
 
 */
    public int findLength(int[] A, int[] B) {
        int lo = 0, hi = Math.min(A.length, B.length) + 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (check(mi, A, B)) lo = mi + 1;
            else hi = mi;
        }
        return lo - 1;
    }
    
    public boolean check(int length, int[] A, int[] B) {
        Set<String> seen = new HashSet();
        for (int i = 0; i + length <= A.length; ++i) {
            seen.add(Arrays.toString(Arrays.copyOfRange(A, i, i+length)));
        }
        for (int j = 0; j + length <= B.length; ++j) {
            if (seen.contains(Arrays.toString(Arrays.copyOfRange(B, j, j+length)))) {
                return true;
            }
        }
        return false;
    }
    
    
    /*
    Time Complexity: O(M*N)O(M∗N), where M, NM,N are the lengths of A, B.

Space Complexity: O(M*N)O(M∗N), the space used by dp.
    
    */
     public int findLengthdp(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) 
                    	ans = memo[i][j];
                }
            }
        }
        return ans;
    }
     
     public static void main (String args[]) {
    	 int[] A = {1,2,3,2,1};
    	 int[] B = {3,2,1,4,7};
    	 
    	 MaximumLengthOfRepeatedSubarray max = new MaximumLengthOfRepeatedSubarray();
    	 max.findLengthdp(A,B);
    	 
     }
}
