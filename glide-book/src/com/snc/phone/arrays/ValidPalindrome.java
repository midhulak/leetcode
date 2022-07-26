package com.snc.phone.arrays;

public class ValidPalindrome {
    /**
    Time complexity : O(n)O(n), in length nn of the string.

We need to iterate thrice through the string:

When we filter out non-alphanumeric characters, and convert the remaining characters to lower-case.
When we reverse the string.
When we compare the original and the reversed strings.
Each iteration runs linear in time (since each character operation completes in constant time). Thus, the effective run-time complexity is linear.

Space complexity : O(n)O(n), in length nn of the string. We need O(n)O(n) additional space to stored the filtered string and the reversed string.
*/
    public boolean isPalindrome(String s) {
        
        if(s.length() == 0)
            return true;
        s = s.toLowerCase();
        
        int left=0;
        int right = s.length() -1;
        
        while(left < right){
            
            //need to ignore is it is not letter or digit 
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

	}

}
