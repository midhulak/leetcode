/*
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.

 

Example 1:


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 */
public class UncrossedLines {
	
	 public static int maxUncrossedLines(int[] A, int[] B) {
	        int aLen = A.length;
			int bLen = B.length;
			
			int[][] dp = new int[aLen+1][bLen+1];
			//dynamic programming A array as row and B array as col is equal take the opposite one and add +1 if not equal take the the max of opposite ones .
			
			for(int i=0 ; i<aLen; i++) {
				for(int j=0; j<bLen; j++) {
					if(A[i] == B[j])
						dp[i+1][j+1] = dp[i][j] +1;
					else
						dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
					
				}
			}
			
			return dp[aLen][bLen];
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[] A = {2,5,1,2,5};
int[] B = {10,5,2,1,5,2};
   maxUncrossedLines(A,B);

	}

}
