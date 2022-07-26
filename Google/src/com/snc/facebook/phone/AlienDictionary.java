package com.snc.facebook.phone;

public class AlienDictionary {
public boolean isAlienSorted(String[] words, String order) {
        
        int[] hash = new int[26];
        
        for(int i=0 ; i < order.length(); i++){
            
            hash[order.charAt(i) - 'a'] = i;
             
        }
        
        for(int i=1 ; i<words.length; i++){
            
            if(compareTwoWords(words[i-1] , words[i] , hash) == 1)
                return false;
            
        }
        
        return true;
       
    }
    
     public int compareTwoWords(String word1 , String word2 , int[] dict){
            
            int min = Math.min(word1.length() , word2.length());
            
            for(int i=0 ; i<min; i++){
                
                if(dict[word1.charAt(i)-'a'] < dict[word2.charAt(i) - 'a'])
                    return 0;
                
               if(dict[word1.charAt(i)-'a'] > dict[word2.charAt(i) - 'a'])
                    return 1;
            }
         
         if(word1.length() == min)
             return 0;
         
         return 1;
            
        }
        

}
