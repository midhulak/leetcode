package com.snc.recursion;


/*
 *   Title: Remove invalid parenthesis
 *
 *   Problem:
 *   Remove the minimum number of invalid parentheses in order to make the input
 *   string valid. Return all possible results.
 *
 *   Note: The input string may contain letters other than the parentheses ( and ).
 *
 *   Execution: javac InvalidParentheses.java && java InvalidParentheses
 */

import java.util.*;


public class RemoveInvalidParan {

    // method checks if character is parenthesis(open 
    // or closed) 
    static boolean isParenthesis(char c) 
    { 
        return ((c == '(') || (c == ')')); 
    } 
      
    // method returns true if string contains valid 
    // parenthesis 
    static boolean isValidString(String str) 
    { 
        int cnt = 0; 
        for (int i = 0; i < str.length(); i++) 
        { 
            if (str.charAt(i) == '(') 
                cnt++; 
            else if (str.charAt(i) == ')') 
                cnt--; 
            if (cnt < 0) 
                return false; 
        } 
        return (cnt == 0); 
    } 
      
    // method to remove invalid parenthesis 
    static List<String> invalidParentheses(String str , List<String> res) 
    { 
        if (str.isEmpty()) 
            return null; 
      
        // visit set to ignore already visited string 
        HashSet<String> visit = new HashSet<String>(); 
      
        // queue to maintain BFS 
        Queue<String> q = new LinkedList<String>(); 
        String temp; 
        boolean level = false; 
      
        // pushing given string as  
        // starting node into queue 
        q.add(str); 
        visit.add(str); 
        while (!q.isEmpty()) 
        { 
            str = q.peek(); q.remove(); 
            if (isValidString(str)) 
            { 
            	res.add(str);
               // System.out.println(str); 
      
                // If answer is found, make level true 
                // so that valid string of only that level 
                // are processed. 
                level = true; 
            } 
            if (level) 
                continue; 
            for (int i = 0; i < str.length(); i++) 
            { 
                if (!isParenthesis(str.charAt(i))) 
                    continue; 
      
                // Removing parenthesis from str and 
                // pushing into queue,if not visited already 
                String a = str.substring(0, i) ;
                String b =  str.substring(i + 1); 
                 temp = a+b;
                //System.out.println("temp is="+temp);
                if (!visit.contains(temp)) 
                { 
                    q.add(temp); 
                    visit.add(temp); 
                } 
            } 
        } 
        return res;
    } 
    
    
  

    public static void main(String[] args) {
    	List<String> list = new ArrayList<String>();
    	
    	
        System.out.println(invalidParentheses("()())()" , list));

    }
    
}