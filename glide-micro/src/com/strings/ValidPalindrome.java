package com.strings;
//easy
public class ValidPalindrome {
	
public boolean isPalindrome(String s) {
        
        int left=0; int right = s.length()-1;
        s=s.toLowerCase();
        
        
     //   (c >= 'a' && c <= 'z')
        
        while(left <= right){
         
            
            while(left <= right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
                
            }
            
             while(left <= right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
                
            }
            
           if(left <= right && s.charAt(left) != s.charAt(right))
               return false;
            
            left++;
            right--;
        }
        
        return true;
    }

                  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome valid = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		valid.isPalindrome(s);

	}

}
