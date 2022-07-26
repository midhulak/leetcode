package com.snc.Arrays;

public class LongestCommonPrefix {
	
	 public static String longestCommonPrefix(String[] strs) {
	        //take each string and keep it in string and check is taht starting chracter of next one if it is then move on to next string if not take out 1 character at a time until it matches...if you remove all of it and still it doe snot match then need to retrun empty.
	   if(strs.length == 0)
	       return "";
	        String prefix = strs[0];
	        for(int i=1 ; i < strs.length; i++){
	            
	        	int ll = strs[i].indexOf(prefix);
	        	System.out.println("prefix--is="+ll);
	        	
	            while(strs[i].indexOf(prefix) != 0){
	                
	                prefix = prefix.substring(0, prefix.length()-1);
	                if(prefix.isEmpty())
	                    return "";
	            }
	        }
	        return prefix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int h = "ab".indexOf("abc");
		
		System.out.println(h);
		System.out.println("abc".substring(0,2));
		
	//	String[] str = { "abc" , "ab" , "abcd"};
		//longestCommonPrefix(str);

	}

}
