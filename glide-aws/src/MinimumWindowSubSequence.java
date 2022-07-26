/**
 * 
 * @author midhula.kadiyala
 *Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 */

// use 2 pointers 1 on string s and other on string t and start compare and increment i all the time and increment j only if i and j chars match
//capture i starting position whenever it matches first time 
//if j reaches the t length then capture end point of i and check is it less than previous string if less get the string from s.substring(start,end) otehriwse 
//just set i pointer to start and j pointer to 0
public class MinimumWindowSubSequence {
	
//	 public static String minWindow(String S, String T) {
//	        String window = "";
//	        int j = 0, min = S.length() + 1;
//	        for (int i = 0; i < S.length(); i++) {
//	            if (S.charAt(i) == T.charAt(j)) {
//	                j++;
//	                if (j == T.length()) {
//	                    int end = i + 1;
//	                    j--;
//	                    while (j >= 0) {
//	                        if (S.charAt(i) == T.charAt(j)) 
//	                        	j--;
//	                        i--;
//	                    }
//	                    j++;
//	                    i++;
//	                    if (end - i < min) {
//	                        min = end - i;
//	                        window = S.substring(i, end);
//	                    }
//	                }
//	            }
//	        }
//	        return window;
//	    }
	 
	 
	 public static String minWindow(String S, String T) {
	        String window = "";
	        int j = 0, min = S.length() + 1;
	        int start=0;
	        for (int i = 0; i < S.length(); i++) {
	            if (S.charAt(i) == T.charAt(j)) {
	                j++;
	                if(j==1)
	                	start=i;
	                
	                if (j == T.length()) {
	                    int end = i + 1;
	                 
	                    if (end - start < min) {
	                        min = end - start;
	                        window = S.substring(start, end);
	                    }
	                    i=start;
	                    j=0;
	                }
	            }
	        }
	        return window;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s ="abcdebdde";
String t = "bde";

System.out.println(minWindow(s,t));

	}

}
