package com.snc.pluginChanges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Tree extends HashMap<String , Tree>{}
public class TreeFour {

	public static Tree buildWordTreeFromSentences(List<String> sentenceList) {
		
		Tree root = new Tree();
		
		for(String sentence : sentenceList) {
			Tree base = root;
			
			for(String word : sentence.split(" ")) {
				
				if(!base.containsKey(word))
					base.put(word ,  new Tree());
				
				base = base.get(word);
			}
		}
		System.out.println(root.toString());
		return root;
	}
	
	public static void main(String[] args) {
		Tree tree = buildWordTreeFromSentences(Arrays.asList("Hello world" , "Hello there"));
	}
}