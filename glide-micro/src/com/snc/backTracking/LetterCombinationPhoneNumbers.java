package com.snc.backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumbers {
	
	 public List<String> letterCombinations(String digits) {
	        StringBuffer sb = new StringBuffer();
	        List<String> result = new ArrayList<>();
	        
	        if(digits.length() == 0)
	            return result;
	        
	        Map<Character , char[]> map = new HashMap<>();
	        
	        map.put('0' , new char[]{});
	        map.put('1' , new char[]{});
	        map.put('2' , new char[]{'a' , 'b' , 'c'});
	        map.put('3' , new char[]{'d' , 'e' , 'f'});
	        map.put('4' , new char[]{'g' , 'h' , 'i'});
	        map.put('5' , new char[]{'j' , 'k' , 'l'});
	        map.put('6' , new char[]{'m' , 'n' , 'o'});
	        map.put('7' , new char[]{'p' ,'q' , 'r' , 's'});
	        map.put('8' , new char[]{'t' , 'u' , 'v'});
	        map.put('9' , new char[]{'w' , 'x' , 'y' , 'z'});
	        
	        dfs(digits , sb , result , map);
	        
	        return result;
	        
	    }
	    
	    
	    public void dfs(String digits , StringBuffer sb ,   List<String> result , Map<Character , char[]> map){
	        
	        
	        if(sb.length() == digits.length()){
	            result.add(sb.toString());
	            return;
	        }
	        
	        for(char ch : map.get(digits.charAt(sb.length()))){
	            sb.append(ch);
	            dfs(digits , sb ,  result , map);
	            sb.deleteCharAt(sb.length()-1);
	            
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
