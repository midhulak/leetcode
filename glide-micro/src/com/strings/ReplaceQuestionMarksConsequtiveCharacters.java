package com.strings;

public class ReplaceQuestionMarksConsequtiveCharacters {

	
	public String modifyString(String s) {
        
	     char[] ch = s.toCharArray();
	        for(int i=0 ; i<ch.length; i++){
	            
	            if(ch[i] == '?')
	            {
	                char replace = 'a';
	                //if prev character nad next character are same as what we are trying to keep taht is a then increment it 
	                //and again check 
	                while(i!=0 && ch[i-1] == replace || (i != ch.length-1 && ch[i+1] == replace))
	                {
	                   replace = (char)(replace+1);
	                    
	                    
	                }
	                ch[i] = replace;
	            }
	        }
	        return new String(ch);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
