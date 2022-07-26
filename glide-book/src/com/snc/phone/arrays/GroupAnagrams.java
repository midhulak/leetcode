package com.snc.phone.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	//https://leetcode.com/problems/group-anagrams/solution/
//  Complexity Analysis

//Time Complexity: O(NK \log K)O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. The outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log K)O(KlogK) time.

//Space Complexity: O(NK)O(NK), the total information content stored in ans.
 
 public List<List<String>> groupAnagrams(String[] strs) {
      
     Map<String , List<String>> anagrams = new HashMap<String , List<String>>();
      for(String word : strs){
          //for each string sort it
         char[] wordChar = word.toCharArray();
         Arrays.sort(wordChar);
         String sortedWord = new String(wordChar);
          //if map contains sorted word then add it to the list
         if(anagrams.containsKey(sortedWord)){
             anagrams.get(sortedWord).add(word);
         }
         else{
             anagrams.put(sortedWord , new ArrayList<String>(Arrays.asList(word)));
           
         }
         
     }
     //finally iterate the map
     List<List<String>> result = new ArrayList<List<String>>();
     for(Map.Entry<String , List<String>> entry : anagrams.entrySet()){
         result.add(entry.getValue());
     }
     return result;
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
