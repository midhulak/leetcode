package com.snc.facebook.phone;

public class PermutationString {
	
	public boolean checkInclusion(String s1, String s2) {
        int[] hash = new int[26];
        
        for(int i=0 ; i<s1.length(); i++){
            
            hash[s1.charAt(i) - 'a']++;
            
        }
        
        int left=0; 
        int right=0;
        int count=s1.length();
        
        
        while(right < s2.length()){
            
            if(hash[s2.charAt(right++) - 'a']-- >= 1){
              
                count--;
            }
                
            
            if(count == 0)
                return true;
            
            if(right-left == s1.length() && hash[s2.charAt(left++) - 'a']++ >= 0){
               count++;
            }
        }
        return false;
    }

}
