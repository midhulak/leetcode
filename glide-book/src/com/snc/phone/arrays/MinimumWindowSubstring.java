package com.snc.phone.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	
/**
 * 
 * https://leetcode.com/problems/minimum-window-substring/solution/
    
    Time Complexity: O(|S| + |T|)O(∣S∣+∣T∣) where |S| and |T| represent the lengths of strings SS and TT. In the worst case we might end up visiting every element of string SS twice, once by left pointer and once by right pointer. |T|∣T∣ represents the length of string TT.

Space Complexity: O(|S| + |T|)O(∣S∣+∣T∣). |S|∣S∣ when the window size is equal to the entire string SS. |T|∣T∣ when TT has all unique characters.

**/
    public String minWindow(String s, String t) {
      int maxlen = 0;
        Map<Character , Integer> tmap = new HashMap<>();
        Map<Character , Integer> smap = new HashMap<>();
        int i=0;
        int j=0;
        String toReturn = "";
    Integer minOcc = Integer.MAX_VALUE;
        
        for(int k=0; k<t.length(); k++){
            char ch = t.charAt(k);
            tmap.put(ch , tmap.getOrDefault(ch,0)+1);
        }
        
   while(true){
       boolean iloop = true;
       boolean jloop = true;
            
            while(i <s.length() && maxlen < t.length()){
                char ch1 = s.charAt(i);
                smap.put(ch1 , smap.getOrDefault(ch1,0)+1);
                
                if(smap.getOrDefault(ch1 ,0) <= tmap.getOrDefault(ch1,0))
                    maxlen++;
                
                i++;
                iloop=false;
            }
              
                // we just increment j an dtry to remove each character and see if that character belong sto T we need to take another character from i and if that is the character i sin T 
       //again trying to remove each charcater and incrementing j if maxclen doe znot decrement will keep on doing the same.
                while(j < i && maxlen == t.length()){
                    String res = s.substring(j,i);
                if(res.length() < minOcc ){
                    minOcc=res.length();
                    toReturn = res;
                }
                    
                    char c1 = s.charAt(j);
                    
                    if(smap.get(c1) == 1)
                        smap.remove(c1);
                    else
                        smap.put(c1 , smap.get(c1)-1);
                    
                    if( smap.getOrDefault(c1 , 0) < tmap.getOrDefault(c1 , 0)){
                        maxlen--;
                    }
                    j++;
                    
                    jloop=false;
                    
                }
       
       if(iloop && jloop)
           break;
                
            }
         return toReturn;
   }
            

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
