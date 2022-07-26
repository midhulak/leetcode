import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */

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
         
         int count = queue.size();
         for(int j=0 ; j< count ; j++){
             
             String curr = queue.poll();
                
        char chs[] = curr.toCharArray();
        
        for(char ch='a'; ch <= 'z' ; ch++){
            for(int i=0 ; i < chs.length; i++){
                
                if(chs[i] == ch) continue;
                
                char old_ch = chs[i];
                
                chs[i] = ch;
                //checking is this value present or not
                String newWord = String.valueOf(chs);
                 if(newWord.equals(endWord)){
                    return level+1;
                 }
              
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        queue.offer(newWord);
                        }
                    
                
                chs[i] = old_ch;
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
