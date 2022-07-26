import java.util.ArrayDeque;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1
Example 2:

Input: A = "abc", B = "bca"
Output: 2
Example 3:

Input: A = "abac", B = "baca"
Output: 2
Example 4:

Input: A = "aabc", B = "abca"
Output: 2
 */

public class Ksimilarity {
	//Stirng A abc and Stirng B is bca
	
	//first add abc to queue and poll it from queue and get neighboors of abc
	
	
	
	public static int kSimilarity(String A, String B) {
        Queue<String> queue = new ArrayDeque();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) 
            	return dist.get(S);
            for (String T: neighbors(S, B)) {
                if (!dist.containsKey(T)) {  // if not visited put it in queue
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
}
	
	 public static List<String> neighbors(String S, String target) {
	        List<String> ans = new ArrayList();
	        int i = 0;
	        //check until s chracter not matches with tartget character
	        for (; i < S.length(); ++i) {
	            if (S.charAt(i) != target.charAt(i)) break;
	        }

	        char[] T = S.toCharArray();
	        
	      //  form which chracter i string not matching compare next character of S matching with ith char in target string
	        //for eg: S:abc  T:bca  S character in a != b character in T string then compare b Character in S i.e b == b charcater in T
	        //if equal then swap those 2 indeces in S string , and again swap it back to check teh otehr strings.
	        for (int j = i+1; j < S.length(); ++j) {
	        	System.out.println("i is="+i);
	            System.out.println("j is="+j);
	            if (S.charAt(j) == target.charAt(i)) {
	                swap(T, i, j);
	                ans.add(new String(T));
	                swap(T, i, j);
	            }
	        }

	        return ans;
	    }
	 
	 public static void swap(char[] T, int i, int j) {
	        char tmp = T[i];
	        T[i] = T[j];
	        T[j] = tmp;
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String A ="abc";
String B = "bca";

   kSimilarity("abc" , "bca");
	}

}
