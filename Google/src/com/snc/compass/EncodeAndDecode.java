package com.snc.compass;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {
	
	 public static String encode(List<String> strs) {
	        if(strs == null || strs.size()==0)
	            return "";
	        StringBuilder sb = new StringBuilder();
	        for(String s : strs){
	            sb.append(s.length()).append("/").append(s);
	        }
	        return sb.toString();
	    }

	    // Decodes a single string to a list of strings.
	    public static List<String> decode(String s) {
	        List<String> res = new ArrayList<>();
	        
	        if(s == null || s.length() == 0)
	            return res;
	        
	        int index = 0;
	        while(index < s.length()){
	            int slash = s.indexOf("/" , index);
	            int length = Integer.valueOf(s.substring(index,slash));
	            res.add(s.substring(slash+1, slash+1+length));
	            index = slash + length + 1;
	        }
	        return res;
	    }
	    
	    public static void main(String[] args) {
	    	List<String> list = new ArrayList<String>();
	    	list.add("Hello");
	    	list.add("Worldiii");
	    	String encodeStr = encode(list);
	    	System.out.println("encoded str="+encode(list));
	    	List<String> res = decode(encodeStr);
	    	
	    	for(String str : res) {
	    		System.out.println(str);
	    	}
	    	
	    	
	    }

}
