package com.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	//sort each word in string an dput in hashmap , if next sorted word present in hashmap that might be anagram for that word then 
	//add that to the list.
	public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String , List<String>> anagrams = new HashMap<String , List<String>>();
         for(String word : strs){
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            String sortedWord = new String(wordChar);
            if(anagrams.containsKey(sortedWord)){
                anagrams.get(sortedWord).add(word);
            }
            else{
                anagrams.put(sortedWord , new ArrayList<String>(Arrays.asList(word)));
              
            }
            
        }
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
