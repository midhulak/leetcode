package com.snc.leetcodechallenges.feb;

import java.util.ArrayList;
import java.util.List;

public class LetetrCasePermutation {
	

	 public List<String> letterCasePermutation(String S) {
	        
	        List<String> res = new ArrayList<>();
	        
	        findAllPerms(res, S , 0);
	        return res;
	        
	    }
	    
	    public void findAllPerms(List<String> res , String word , int start){
	        
	        res.add(word);
	        for(int i=start; i<word.length(); i++){
	            
	            char[] wordArray = word.toCharArray();
	            
	            if(Character.isLetter(word.charAt(i))){
	                
	                if(Character.isUpperCase(word.charAt(i))){
	                    
	                    wordArray[i] = Character.toLowerCase(word.charAt(i));
	                    findAllPerms(res , String.valueOf(wordArray) , i+1);
	                }
	                
	                else{
	                    
	                    wordArray[i] = Character.toUpperCase(word.charAt(i));
	                    findAllPerms(res , String.valueOf(wordArray) , i+1);
	                }
	                
	            }
	        }
	    }
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LetetrCasePermutation l = new LetetrCasePermutation();
		l.letterCasePermutation("a1b2");
		
		
	}

}
