package com.snc.compass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParenthesis {
	
	
	 public List<String> removeInvalidParentheses(String s) {
	        List<String> res = new ArrayList<String>();
	        HashSet<String> visited = new HashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        
	        queue.add(s);
	        visited.add(s);
	        boolean level = false;
	        while(!queue.isEmpty()){
	            String str = queue.peek();
	            queue.remove();
	            if(isValid(str)){
	            
	            res.add(str);
	                level=true;
	            
	        }
	            
	            if(level)
	                continue;
	            else{
	                
	                
	                for(int i=0; i<str.length(); i++){
	                    
	                    if( !(str.charAt(i) == '(' || str.charAt(i) == ')') )
	                        continue;
	                        
	                    
	                    String temp = str.substring(0,i) + str.substring(i+1);
	                    
	                    if(!visited.contains(temp)){
	                        
	                        visited.add(temp);
	                        queue.add(temp);
	                    }
	                    
	                
	                
	            }
	            
	        }
	        
	    }
	        return res;
	    }
	    public boolean isValid(String s){
	        int count=0;
	        for(int i=0 ; i<s.length(); i++){
	            
	            if(s.charAt(i) == '(')
	                count++;
	            else if(s.charAt(i) == ')')
	                count--;
	            
	            if(count < 0)
	                return false;
	            
	          
	        }
	        return (count == 0); 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
