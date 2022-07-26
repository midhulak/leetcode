package com.snc.sorting.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**]
 * 
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
/**
 * Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 
 * @author midhula.kadiyala
 *
 
 
 Time Complexity: \mathcal{O}(N^2 + 2 ^ N + W)O(N 
2
 +2 
N
 +W)

As we discussed before, in the worst case, it could be possible to insert a break between every adjacent characters in the input string, i.e. each prefix of length kk would have 2 ^ {k-1}2 
k−1
  number of solutions.

While we iterate over all prefixes of the input string, starting from the empty prefix, the number of solutions for each prefix would double at each step.

Assume that we adopt the most optimal recursive encoding for the solutions, we would need kk steps to build solutions for the prefix of length kk. In total, we would need \sum_{i=1}^{N}{i} = \frac{(N+1) \cdot N}{2}∑ 
i=1
N
​
 i= 
2
(N+1)⋅N
​
  steps to build all intermediate solutions.

However, at the end, we need to reconstruct the solutions from the encoding. In the worst case, we would have 2 ^ {N-1}2 
N−1
  number of solutions. Thus it would take at least 2 ^ {N-1}2 
N−1
  steps to reconstruct the solutions.

Similarly, it would take WW steps to build the word set from the dictionary.

In total, the overall time complexity for the bottom-up DP approach with the recursive encoding is \mathcal{O}(\frac{(N+1) \cdot N}{2} + 2 ^ {N-1} + W ) = \mathcal{O}(N^2 + 2 ^ N + W)O( 
2
(N+1)⋅N
​
 +2 
N−1
 +W)=O(N 
2
 +2 
N
 +W).

Space Complexity: \mathcal{O}(2^N \cdot N + N^2 + W)O(2 
N
 ⋅N+N 
2
 +W)
 
 **/

public class WordBreakII {
	
	  public List<String> wordBreak(String s, List<String> wordDict) {
	        List<String> results = new ArrayList<String>();
	        Set<String> set = new HashSet<String>();
	       for(String dict : wordDict){
	           set.add(dict); 
	       }
	        wordBreak(new ArrayList<String>() , s , set , results);
	        Collections.sort(results , Collections.reverseOrder()); 
	         return results;
	        
	    }
	    
	    private static void wordBreak(List<String> curr, String remainder , Set<String> wordDict , List<String> results){
	        
	        if(remainder.length() == 0){
	            StringBuilder sb = new StringBuilder();
	            
	            for(int i=0 ; i<curr.size(); i++){
	                sb.append(curr.get(i)+" ");
	            }
	            results.add(sb.toString().strip());
	            return;
	        }
	        
	        for(int i=1 ; i <= remainder.length(); i++){
	            String subStr = remainder.substring(0,i);
	            
	                 
	                if(wordDict.contains(subStr)){
	                    curr.add(subStr);
	                 wordBreak(curr , remainder.substring(i, remainder.length()) , wordDict , results);
	                    curr.remove(curr.size()-1);
	                  
	                }
	            
	            
	        }
	        
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//				Output: ["cats and dog","cat sand dog"]
//						
						List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		WordBreakII word = new WordBreakII();
		word.wordBreak("catsanddog", dict);
		

	}

}

