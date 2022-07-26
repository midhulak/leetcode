package Google;

public class LongestIncreasingSequence {
	public static void main(String[] args) {
        int[] a = {21, 23, 28, 23, 29, 32, 38, 28, 30, 29, 25, 24};
        int[] arr = {1, 7, 7, 2, 3, 6, 7, 6, 7, 0, 8, 2, 4, 9, 8, -20};
        System.out.println(FindLongest(arr));
        System.out.println(LongestIncreasingSubsequenceLength(arr, arr.length));

    }
	static int CeilIndex(int A[], int l, int r, int key) 
    { 
        while (r - l > 1) { 
            int m = l + (r - l) / 2; 
            if (A[m] >= key) 
                r = m; 
            else
                l = m; 
        } 
  
        return r; 
    } 
  
    static int LongestIncreasingSubsequenceLength(int A[], int size) 
    { 
        // Add boundary case, when array size is one 
  
        int[] tailTable = new int[size]; 
        int len; // always points empty slot 
  
        tailTable[0] = A[0]; 
        len = 1; 
        for (int i = 1; i < size; i++) { 
            if (A[i] < tailTable[0]) 
                // new smallest value 
                tailTable[0] = A[i]; 
  
            /*else if (A[i] > tailTable[len - 1]) 
                // A[i] wants to extend largest subsequence 
                tailTable[len++] = A[i]; */
  
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i]; 
        } 
  
        return len; 
    } 
    public static int FindLongest(int[] a) {
        int n = a.length - 1;
        int currentIncreasingSequenceCount = 0;
        int longestIncreasingSequenceCount = 0;

        for(int i = 0; i < n; i++) {
            if(a[i] < a[i + 1]) {
                currentIncreasingSequenceCount++;
            }
            else {
                currentIncreasingSequenceCount = 0;
            }

            if(currentIncreasingSequenceCount > longestIncreasingSequenceCount) {
                longestIncreasingSequenceCount = currentIncreasingSequenceCount;
            }

        }

        return longestIncreasingSequenceCount+1;
    }
}
