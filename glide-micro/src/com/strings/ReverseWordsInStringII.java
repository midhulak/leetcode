package com.strings;

public class ReverseWordsInStringII {
	
    
	 public void reverseWords(char[] s) {
	        
	        reverse(s , 0 , s.length-1);
	        
	        int i=0;
	        for(int j=0 ; j <= s.length; j++){
	            
	            if(j == s.length || s[j] == ' '){
	                reverse(s , i , j-1);
	                i=j+1;
	            }
	           
	        }
	        
	    }
	    
	    public void reverse(char[] ch , int left , int right){
	        
	        while(left < right){
	            char temp = ch[left];
	            ch[left] = ch[right];
	            ch[right] = temp;
	            left++;
	            right--;
	        }
	    }



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
