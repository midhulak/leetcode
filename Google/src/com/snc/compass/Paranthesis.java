package com.snc.compass;
import java.util.*;
public class Paranthesis {

	



    
    //String input = "([)])";
    public boolean isValid(String input) {
        
    HashMap<String , String> map = new HashMap<String , String>();
        map.put("(" , ")");
        map.put("[" , "]");
        map.put("{" , "}");
        
        Stack stack = new Stack<String>();
        
        for(int i=0 ; i<input.length(); i++){
            System.out.println("input="+input.charAt(i));
            if(map.containsKey(input.charAt(i)+"")){
                stack.push(input.charAt(i)+"");
            }
            else{
                if(stack.isEmpty())
                	return false;
                
                String open = (String) stack.pop();
               
              
              
                String check1 = map.get(open).toString();
                String check2 = input.charAt(i)+"";
               if(!check1.equals(check2))
                   return false;
                
                
               
            }
                
            
        }
        if(stack.isEmpty())
        return true;
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paranthesis p = new Paranthesis();
		System.out.println(p.isValid("(()(()))"));
	}

}
