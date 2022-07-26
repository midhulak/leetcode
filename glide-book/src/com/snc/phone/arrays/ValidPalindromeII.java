package com.snc.phone.arrays;

public class ValidPalindromeII {
	
/*
    https://leetcode.com/problems/valid-palindrome-ii/solution/
    
    Time complexity: O(N)O(N).

The main while loop we use can iterate up to N / 2 times, since each iteration represents a pair of characters. On any given iteration, we may find a mismatch and call checkPalindrome twice. checkPalindrome can also iterate up to N / 2 times, in the worst case where the first and last character of s do not match.

Because we are only allowed up to one deletion, the algorithm only considers one mismatch. This means that checkPalindrome will never be called more than twice.

As such, we have a time complexity of O(N)O(N).

Space complexity: O(1)O(1).

The only extra space used is by the two pointers i and j, which can be considered constant relative to the input size.

*/
    public boolean validPalindrome(String s) {
        
        if(s.length() == 0)
            return true;
        
        int left=0;
        int right = s.length()-1;
        
        while(left < right){
            
            
            if(s.charAt(left) != s.charAt(right))
               return  isValid(s , left+1 , right) || isValid(s , left , right-1);
            
            left++;
            right--;
                
        }
        
        return true;
    }
    
    public boolean isValid(String s , int left , int right){
        
        while(left < right){
            
            if(s.charAt(left) != s.charAt(right))
                 return false;
            
            left++;
            right--;
            
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
