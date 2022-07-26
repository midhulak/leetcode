package com.strings;

import java.util.LinkedList;

public class SmallestSubsequenceLexographical {

	public String smallestSubsequence(String s) {
        
        int[] letters = new int[26];
        
        for(int i=0; i<s.length(); i++){
            letters[s.charAt(i) - 'a']++;
        }
        
        LinkedList<Character> result = new LinkedList<>();
        boolean[] characterInResult = new boolean[26];
        
        
        
        for(int i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            letters[ch -'a']--;
            
            if(characterInResult[s.charAt(i) - 'a'])
                continue;
            
            while(!result.isEmpty() && ch < result.getLast() && letters[result.getLast() - 'a'] > 0){
               
                characterInResult[result.removeLast() - 'a'] = false;
            }
            
            result.add(ch);
            
            characterInResult[ch - 'a'] = true;
        }
        
        StringBuffer sb = new StringBuffer();
        while(!result.isEmpty()){
            sb.append(result.removeFirst());
            
        }
        
        return sb.toString();
        
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
