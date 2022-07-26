package com.snc.affirm;

public class GroupAnagrams {
	
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
