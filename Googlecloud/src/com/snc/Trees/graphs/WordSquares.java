package com.snc.Trees.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=YTQjsPiMtRk

public class WordSquares {
	
	
//  [b a l l]  .//next serach for word starts with a in second col then add it now added area
//  [a r e a] //next search for word starts with le in 3rd col , and word is lead add it
//  [l e a d] //next search for word starts with lad in 4 col , and word is lady add it
//  [l a d y]
 Map<String, List<String>> map = new HashMap<>();
 public List<List<String>> wordSquares(String[] words) {
     
     List<List<String>> result = new ArrayList<>();
     
     createPrefixMap(words);
     
     for(int i=0; i<words.length; i++){
         LinkedList<String> linkedList = new LinkedList<>();
         linkedList.add(words[i]);
         backTrack(result , 1  , linkedList , words[i].length());
     }
     
     return result;
 }
 
 
 public void backTrack(List<List<String>> result , int step , LinkedList<String> list , int n){
     
     if(list.size() == n)
     {
         result.add(new ArrayList<>(list));
         return;
     }
     
     StringBuilder sb = new StringBuilder();
     
     for(String str : list){
         sb.append(str.charAt(step));
     }
     
     List<String> getPrefixList= map.getOrDefault(sb.toString() , new ArrayList<>());
     
     for(String word : getPrefixList){
         list.add(word);
         backTrack(result , step+1 , list , n);
         list.removeLast();
     }
     
 }
 
 
 //trying to add all prefixes for eg: our list is area, lead,wall,lady,ball
// a -> [area] ar-> [area] are ->[area] area -> [area] l - > [lead] le -> [lead] lea -> [lead] lead -> [lead]
 //b -> [ball] ba ->[ball] ---so on
 private void  createPrefixMap(String[] words){
     
     for(String word : words){
         for(int i=0; i<word.length(); i++){
             String prefix = word.substring(0,i);
             map.putIfAbsent(prefix , new ArrayList<>());
             
             List<String> prefixes = map.get(prefix);
             prefixes.add(word);
             
             }
     }
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"area","lead","wall","lady","ball"};
	}

}
