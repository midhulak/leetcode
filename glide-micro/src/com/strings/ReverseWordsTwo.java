package com.strings;

public class ReverseWordsTwo {
	
//	Input: s = "Let's take LeetCode contest"
//			Output: "s'teL ekat edoCteeL tsetnoc"

	  public String reverseWords(String s) {
	        
	         if(s.length() == 0 || s == null)
	            return s;
	        
	        char[] ch = s.toCharArray();
	        
	       
	        
	        int j=0;
	        int i=0;
	        
	        while(j <= ch.length){
	            
	            if(j == ch.length || ch[j] == ' ')
	            {
	                reverse(ch , i , j-1);
	                i=j+1;
	            }
	            j++;
	        }
	        
	        return new String(ch);
	    }
	    
	    public void reverse(char[] ch , int i , int j){
	        
	        while(i < j){
	            
	            char temp = ch[i];
	            ch[i] = ch[j];
	            ch[j] = temp;
	            i++;
	            j--;
	        }
	    }
	
}
