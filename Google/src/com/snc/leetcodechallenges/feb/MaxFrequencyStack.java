package com.snc.leetcodechallenges.feb;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFrequencyStack {
	

	    Map<Integer, Integer> frequencyMap=null;
	    Map<Integer , Stack<Integer>> sameFrequencyMap=null;
	    int maxFreqCount;

	    public MaxFrequencyStack() {
	        frequencyMap = new HashMap<>();
	        sameFrequencyMap = new HashMap<>();
	      maxFreqCount=0;
	    }
	    
	    public void push(int x) {
	        
	        if(frequencyMap.containsKey(x)){
	            frequencyMap.put(x , frequencyMap.get(x)+1);
	         }
	        else{
	            frequencyMap.put(x , 1);
	        }
	        
	     if(frequencyMap.get(x) > maxFreqCount){
	         
	         maxFreqCount = frequencyMap.get(x);
	         
	     }
	        
	     int key = frequencyMap.get(x);
	     
	     System.out.println("key is="+key);
	        if(sameFrequencyMap.containsKey(key)){
	            
	            Stack<Integer> stack = sameFrequencyMap.get(key);
	            stack.push(x);
	            sameFrequencyMap.put(key , stack);
	        }
	        else{
	            Stack<Integer> newStack = new Stack<Integer>();
	            newStack.push(x);
	            sameFrequencyMap.put(key , newStack);
	        }
	        
	    }
	    
	    public int pop() {
	           int returnVal=-1;
	        if(!sameFrequencyMap.get(maxFreqCount).isEmpty()){
	      returnVal = sameFrequencyMap.get(maxFreqCount).pop();
	        
	        if(sameFrequencyMap.get(maxFreqCount).size() == 0)
	            maxFreqCount--;
	        
	        frequencyMap.put(returnVal , frequencyMap.get(returnVal)-1);
	        }
	        
	        return returnVal;
	     
	    }
	            
	       
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxFrequencyStack max = new MaxFrequencyStack();
		max.push(4);
		max.push(0);
		max.push(9);
		max.push(3);
		max.push(4);
		max.push(2);
		System.out.println(max.pop());
		
		

	}

}
