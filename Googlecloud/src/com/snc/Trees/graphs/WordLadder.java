package com.snc.Trees.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	
	/**
	 * Time Complexity: O({M}^2 \times N)O(M 
2
 ×N), where MM is the length of each word and NN is the total number of words in the input word list.

For each word in the word list, we iterate over its length to find all the intermediate words corresponding to it. Since the length of each word is MM and we have NN words, the total number of iterations the algorithm takes to create all_combo_dict is M \times NM×N. Additionally, forming each of the intermediate word takes O(M)O(M) time because of the substring operation used to create the new string. This adds up to a complexity of O({M}^2 \times N)O(M 
2
 ×N).

Breadth first search in the worst case might go to each of the NN words. For each word, we need to examine MM possible intermediate words/combinations. Notice, we have used the substring operation to find each of the combination. Thus, MM combinations take O({M} ^ 2)O(M 
2
 ) time. As a result, the time complexity of BFS traversal would also be O({M}^2 \times N)O(M 
2
 ×N).

Combining the above steps, the overall time complexity of this approach is O({M}^2 \times N)O(M 
2
 ×N).

Space Complexity: O({M}^2 \times N)O(M 
2
 ×N).

Each word in the word list would have MM intermediate combinations. To create the all_combo_dict dictionary we save an intermediate word as the key and its corresponding original words as the value. Note, for each of MM intermediate words we save the original word of length MM. This simply means, for every word we would need a space of {M}^2M 
2
  to save all the transformations corresponding to it. Thus, all_combo_dict would need a total space of O({M}^2 \times N)O(M 
2
 ×N).
Visited dictionary would need a space of O(M \times N)O(M×N) as each word is of length MM.
Queue for BFS in worst case would need a space for all O(N)O(N) words and this would also result in a space complexity of O(M \times N)O(M×N).
Combining the above steps, the overall space complexity is O({M}^2 \times N)O(M 
2
 ×N) + O(M * N)O(M∗N) + O(M * N)O(M∗N) = O({M}^2 \times N)O(M 
2
 ×N) space.

Optimization: We can definitely reduce the space complexity of this algorithm by storing the indices corresponding to each word instead of storing the word itself.

	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	
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
