package com.snc.gotanoffer.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonBanned {
	/**
	 * Let NN be the number of characters in the input string and MM be the number of characters in the banned list.

//Time Complexity: O(N+M).

We traverse each character in the input string once and only once. At each iteration, it takes constant time to perform the operations, except the operation that we build a new string out of the buffer. Excluding the cost of string-building out of the iteration, we can consider the cost of iterations as \mathcal{O}(N)O(N).

If we combine all the string-building operations all together, in total it would take another \mathcal{O}(N)O(N) time.

In addition, we built a set out of the list of banned words, which would take \mathcal{O}(M)O(M) time.

Hence, the overall time complexity of the algorithm is \mathcal{O}(N) + \mathcal{O}(N) + \mathcal{O}(M) = \mathcal{O}(N + M)O(N)+O(N)+O(M)=O(N+M).

//Space Complexity: O(N+M).

We built a hashmap to count the frequency of each unique word, whose space would be of \mathcal{O}(N)O(N).

Similarly, we built a set out of the banned word list, which would consume additional \mathcal{O}(M)O(M) space.

Therefore, the overall space complexity of the algorithm is \mathcal{O}(N + M)O(N+M).
	 * @param paragraph
	 * @param banned
	 * @return
	 */
	
//	Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
//
//			Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
//
//			 
//
//			Example:
//
//			Input: 
//			paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//			banned = ["hit"]
//			Output: "ball"
//			Explanation: 
//			"hit" occurs 3 times, but it is a banned word.
//			"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
//			Note that words in the paragraph are not case sensitive,
//			that punctuation is ignored (even if adjacent to words, such as "ball,"), 
//			and that "hit" isn't the answer even though it occurs more because it is banned.

	
	   public String mostCommonWord(String paragraph, String[] banned) {
	        Map<String, Integer> count = new HashMap<>();
	        Set<String> ban = new HashSet<>();
	        //first add the banned words in the set
	        for (String s: banned) {
	            ban.add(s); 
	        }
	        //trying to remove punctuation marks with the words which has comma and dots etc
	        String normalized = lowerCaseAndRemovePunctuation(paragraph);
	        
	        //trying to spliut words with spaces and calculate frequency and store it in map if it does not contain in ban words..
	        for (String s: normalized.split("\\s+")) {
	            if (!s.isEmpty() && !ban.contains(s)) {
	                count.put(s, count.getOrDefault(s, 0) + 1);
	            }
	        }
	        
	        String result = null;
	        int maxCount = 0;
	        //and retiurn the string which has max value.
	        for (Map.Entry<String, Integer> kv: count.entrySet()) {
	            if (kv.getValue() > maxCount) {
	                maxCount = kv.getValue();
	                result = kv.getKey();
	            }
	        }
	        
	        return result;
	    }
	    
	    private String lowerCaseAndRemovePunctuation(String s) {
	        StringBuilder bd = new StringBuilder();
	        for (Character c: s.toCharArray()) {
	            if (Character.isLetter(c) || c == ' ') bd.append(Character.toLowerCase(c));
	            else bd.append(' ');
	        }
	        return bd.toString();
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
