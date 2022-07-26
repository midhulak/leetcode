package com.snc.phone.strings;

public class ValidPalindrome {
	
public boolean isPalindrome(String s) {
        
        if(s.length() == 0)
            return true;
        s = s.toLowerCase();
        
        int left=0;
        int right = s.length() -1;
        
        while(left < right){
            
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
           
            while(left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            
            if(left <= right && s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
            
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		
		ValidPalindrome p = new ValidPalindrome();
		System.out.println(p.isPalindrome(s));
	}

}
