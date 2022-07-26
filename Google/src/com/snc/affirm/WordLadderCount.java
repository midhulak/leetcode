package com.snc.affirm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderCount {
	
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        HashSet<String> set = new HashSet<String>();
	        
	        for(String str : wordList){
	            set.add(str);
	        }
	        
	        
	        if(!set.contains(endWord))
	            return 0;
	        
	        Queue<String> queue = new LinkedList<>();
	        queue.offer(beginWord);
	        
	        int level=1;
	        
	        while(!queue.isEmpty()){
	            
	            int size = queue.size();
	            
	            for(int j=0 ; j<size; j++){
	                
	                String curr = queue.poll();
	                
	                char chs[] = curr.toCharArray();
	                
	                for(char ch='a' ; ch <= 'z' ; ch++){
	                    
	                    for(int i=0 ; i<chs.length; i++){
	                        
	                        if(ch == chs[i])
	                            continue;
	                        
	                        char old = chs[i];
	                        
	                        chs[i] = ch;
	                        
	                        String newWord = String.valueOf(chs);
	                        
	                        if(newWord.equals(endWord))
	                            return level+1;
	                        
	                        if(set.contains(newWord)){
	                            
	                            set.remove(newWord);
	                            queue.offer(newWord);
	                        }
	                         chs[i] = old;
	                    }
	                }
	                
	            }
	            
	            level++;
	        }
	        
	        return 0;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
