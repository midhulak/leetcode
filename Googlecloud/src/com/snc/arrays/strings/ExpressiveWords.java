package com.snc.arrays.strings;

public class ExpressiveWords {
	
	//https://leetcode.com/problems/expressive-words/
	//TC: O(n)  sC: O(1)
	
	  //. query word      result    Strechie(Y/N)
    //     " "              " "         Y
    //      "a"             "a"         y
    //      "a"             "aa"        N. (atleast 3 in result)
    //      "a"             "aaa"       Y
    //    "aaaa"            "aaa"       N (query word is greater than the result word)
    //     "a"              "b"        N
    
    
    //first check each char is equal
    //then check how far it is extended in query string and also in result string
    //then compare the lengths with the above table and see if result length >=3 and query length < result lengt
	//h || either both are equal
     
    public int expressiveWords(String s, String[] words) {
        int count=0;
        for(String word : words){
            
            if(check(word , s))
                count++;
        }
        return count;
    }
    
    
    public boolean check(String queryWord , String origWord){
        
        int q=0;
        int r=0;
        
        while(q < queryWord.length() && r < origWord.length()){
            
            
            char queryChar = queryWord.charAt(q);
            char resultChar = origWord.charAt(r);
            
            if(queryChar == resultChar){
                
                int queryLen = getLen(q , queryWord);
                int resLen = getLen(r ,origWord );
                
               if(queryLen == resLen || resLen >= 3 && queryLen < resLen ){
                   q = q+queryLen;
                r = r+resLen;
               }
                else
                {
                    return false;
                }
                
                
            }
            else
            {
                return false;
            }
            
        }
        return q == queryWord.length() && r == origWord.length();
        
    }
    
    public int getLen(int i , String queryWord){
        int count=1;
        i++;
        for(;i < queryWord.length(); i++){
            
            if(queryWord.charAt(i-1) != queryWord.charAt(i))
                return count;
            
            count++;
        }
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
