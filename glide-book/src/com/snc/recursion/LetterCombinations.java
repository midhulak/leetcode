package com.snc.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	
	//https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
	 /**
    Time complexity: O(4^N \cdot N)O(4 
N
 ⋅N), where NN is the length of digits. Note that 44 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.

The worst-case is where the input consists of only 7s and 9s. In that case, we have to explore 4 additional paths for every extra digit. Then, for each combination, it costs up to NN to build the combination. This problem can be generalized to a scenario where numbers correspond with up to MM digits, in which case the time complexity would be O(M^N \cdot N)O(M 
N
 ⋅N). For the problem constraints, we're given, M = 4M=4, because of digits 7 and 9 having 4 letters each.

Space complexity: O(N)O(N), where NN is the length of digits.

**/
    
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
