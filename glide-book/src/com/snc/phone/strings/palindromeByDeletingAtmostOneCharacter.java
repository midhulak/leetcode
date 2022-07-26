package com.snc.phone.strings;

public class palindromeByDeletingAtmostOneCharacter {
	
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
