package com.strings;

public class ReverseWords {
	
	 public String reverseWords(String s) {
	        
	        if(s == null || s.length() == 0)
	            return "";
	        
	        String[] split = s.split(" ");
	        StringBuffer sb = new StringBuffer();
	        
	        for(int i=split.length-1 ; i>=0; i--){
	            if(split[i].length() == 0)
	                continue;
	            sb.append(split[i]);
	            sb.append(" ");
	        }
	        return sb.toString().trim();
	    }
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
