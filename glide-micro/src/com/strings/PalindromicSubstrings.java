package com.strings;

public class PalindromicSubstrings {
	//just take even length and odd length ..if both characters are equal try to open the window from right side and 
	//open the window from  left side
public int countSubstrings(String s) {
        
		int res=0;
		for(int i=0 ; i<s.length(); i++) {
			
		res += countPalindromic(s ,i , i );
		res += countPalindromic(s , i , i+1);
				
		}
		return res;
    }
    
    public int countPalindromic(String s , int left , int right) {
		
		
		int res=0;
		
		while(left >=0 && right < s.length()) {
			
			if(s.charAt(left) != s.charAt(right))
				break;
			
			left--;
			right++;
			
			res++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
