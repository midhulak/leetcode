package com.strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	
	 public boolean isValid(String input) {
	        //"([)]"
	    HashMap<String , String> map = new HashMap<String , String>();
	        map.put("(" , ")");
	        map.put("[" , "]");
	        map.put("{" , "}");
	        
	        Stack stack = new Stack<String>();
	        
	        for(int i=0 ; i<input.length(); i++){
	            if(map.containsKey(input.charAt(i)+"")){
	                stack.push(input.charAt(i)+"");
	            }
	            else{
	                if(stack.isEmpty())
	                    return false;
	                
	                String open = (String) stack.pop();
	               if(!( (map.get(open)).equals(input.charAt(i)+"")))
	                   return false;
	                
	               
	            }
	                
	            
	        }
	       if(stack.isEmpty())
	           return true;
	        
	        return false;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
