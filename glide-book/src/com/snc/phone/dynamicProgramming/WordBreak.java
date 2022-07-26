package com.snc.phone.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	  /**
    Time complexity : O(2^n)O(2 
n
 ). Given a string of length nn, there are n + 1n+1 ways to split it into two parts. At each step, we have a choice: to split or not to split. In the worse case, when all choices are to be checked, that results in O(2^n)O(2 
n
 ).

Space complexity : O(n)O(n). The depth of the recursion tree can go upto nn.


**/
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] T = new boolean[s.length()+1];
        Set<String> set = new HashSet<>();
        
        for(String word : wordDict){
            
            set.add(word);
        }
        
        T[0] = true;
        
        for(int i=0 ; i<=s.length(); i++){
            
            for(int j=0; j <i; j++){
                
                if(T[j] && set.contains(s.substring(j,i))){
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }
    
    
		// public static List<String> wordBreak(String s, Set<String> dict) {
		// List<String> results = new LinkedList<String>();
		// wordBreak(new ArrayList<String>(), s, dict, results);
		// return results;
		// }
		// private static void wordBreak(List<String> curr, String remainder, Set<String> dict, List<String> results) {
		// if (remainder.length() == 0) {
		// StringBuilder sb = new StringBuilder();
		// for (int i = 0; i < curr.size() ; i++) {
		// sb.append(curr.get(i) + " ");
		// }
		// sb.append(curr.get(curr.size() - 1));
		// results.add(sb.toString());
		// return;
		// }
		// for (int i = 1; i <= remainder.length(); i++) {
		// String substr = remainder.substring(0, i);
		// if (dict.contains(substr)) {
		// curr.add(substr);
		// wordBreak(curr, remainder.substring(i, remainder.length()), dict, results);
		// curr.remove(curr.size() - 1);
		// }
		// }
		// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
