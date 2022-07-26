package com.snc.compass;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        //send 2 params open and close
        backTrack(result , "" , 0 , 0 , n);
        
        return result;
        
    }
    
    public static void backTrack(List<String> result , String curr , int open , int close , int max){
        if(curr.length() == max*2){
            
            result.add(curr);
            return;
        }
        
        
        if(open<max)
            backTrack(result , curr+"(" , open+1 , close , max);
        
        if(close < open)
            backTrack(result , curr+")" , open , close+1 , max);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
