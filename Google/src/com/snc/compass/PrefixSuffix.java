package com.snc.compass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrefixSuffix {
	
	 class Trie{
		
		Trie[] children ;
		List<Integer> index;
		
		Trie(){
			children = new Trie[26];
			index = new ArrayList<>();
		}
		
		public  void insert(String word , int i) {
			
			Trie node = this;
			
			for(char ch : word.toCharArray()) {
				
				if(node.children[ch - 'a'] == null) {
					node.children[ch - 'a'] = new Trie();
				}
				node = node.children[ch - 'a'];
				node.index.add(i);
			}
		}
		
		
		public  List<Integer> startsWith(String word){
			
			Trie node = this;
			
			for(char c : word.toCharArray()) {
				
				if(node.children[c - 'a'] == null)
					return new ArrayList<>();
				
				node=node.children[c - 'a'];
			}
			return node.index;
		}
	}
	

	//trying to insert each word in trie data structure
	Trie prefix = null;
	Trie suffix = null;
	public PrefixSuffix(String[] words) {
		prefix = new Trie();
		suffix = new Trie();
		
		for(int i=0 ; i<words.length; i++) {
			prefix.insert(words[i], i);
			suffix.insert(new StringBuilder(words[i]).reverse().toString(), i);
		}
	}
	
	
	public int f(String pre , String suff) {
		List<Integer> pList = prefix.startsWith(pre);
		List<Integer> sList = suffix.startsWith(new StringBuilder(suff).reverse().toString());
		
		int i=pList.size()-1; 
		int j = pList.size()-1;
		
		
		for(int k=0; k<pList.size(); k++) {
			System.out.println(pList.get(k));
		}
		
		for(int l=0; l<sList.size(); l++) {
			System.out.println(sList.get(l));
		}
		
//		for(Integer pre1 : pList) {
//			System.out.println("Pre are="+pre1);
//		}
//		
//		for(Integer suff1 : sList) {
//			System.out.println("suff are="+suff1);
//		}
		
//		while(i >= 0 && j >= 0) {
//			if(Objects.equals(pList.get(i), sList.get(j)))
//				return pList.get(i);
//			else if(pList.get(i) > sList.get(j))
//				i--;
//			else
//				j--;
//		}
		return -1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] words = {"apple" , "applet"  , "ape"};
		
		PrefixSuffix p = new PrefixSuffix(words);
		 System.out.println(p.f("a", "e"));
		
	}

}
