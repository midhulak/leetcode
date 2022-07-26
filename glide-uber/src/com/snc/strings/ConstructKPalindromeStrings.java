package com.snc.strings;

public class ConstructKPalindromeStrings {
	/*https://leetcode.com/problems/construct-k-palindrome-strings/ */
	  //to make palindrome we need pair of same characters and 1 odd number of character so that left side even char and right side even char and middle odd 
    
	//TC: O(n)
	//SC: O(26)
	public boolean canConstruct(String s, int k) {
        
        int[] chars = new int[26];
        int n = s.length();
        /** first trying to put all chars in an array and increment the count **/
        for(int i=0; i<s.length(); i++){
           chars[s.charAt(i) - 'a']++;
        }
        
        int odd=0;
        int even=0;
        
        for(int i=0; i<26; i++){
            //for each character checking how many times it is present and also how many pairs it is present
            
            //if remainder is 1 definitely it has 1 odd
            if(chars[i] %2 != 0){
                odd++;
                //and from odd number if you remove 1 it will be even so remove 1 and add it to even count as well
                even+=(chars[i]-1)/2;
            }
            //if mod is zero we can just add pairs of that char
            else
                even+=chars[i]/2;
        }
        //if our number of palindromes is less than string length we can not make those many palindromes
        if(k > n)
            return false;
        //if constructed number shud be less than or equal to characters which we can not make pairs if odd characters are less than constructed pairs we can make palindrome
        if(k < odd)
            return false;
       //then return true 
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
