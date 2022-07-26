package com.snc.others;

import java.util.HashMap;

public class IsIsomorphic {
	
	  // e-> a.   a - true
    // g ->d.   d true
        
     // a b a c b a
    //. x y x y y x
    
    // a -> x.  x true
    // b -> y.  y true
    // c -> y.  --here y is already used so not isomorphic    
    
    
      //foko. barr
    
    //f -> b.  b -> T
    //o -> a.  a -> T  (no r present)
    //k -> r   r -> T 
        
    
    //track which characters map to whcih character in another string by using 2 hashmaps
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        HashMap<Character , Character> sMap = new HashMap<>();
        HashMap<Character , Boolean> tMap = new HashMap<>();
        
        
        for(int i=0; i<s.length() ; i++){
            char firstStr = s.charAt(i);
            char  secStr= t.charAt(i);
            
            //if alrrady present checking the mapping value same as second string mapping value
            if(sMap.containsKey(firstStr) ){
               
                if(!sMap.get(firstStr).equals(secStr))
                    return false;
            
            }
            //if not present then checking the map value is already present for previous mapping
                   else{
                       if(tMap.containsKey(secStr))
                           return false;
                       sMap.put(firstStr , secStr);
                       tMap.put(secStr , true);
                   }
        }
            
                   return true;
    }
               

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
