package com.snc.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyWord {
	
	static Map<String , Integer> map = new HashMap<>();
	
	
	public static void printWords(String str) {
		
		String[] count = str.split(" ");
		
		for(int i=0; i<count.length; i++) {
			
			map.put(count[i], map.getOrDefault(count[i], 1)+1);
		}
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("word is="+entry.getKey());
			System.out.println("value is="+entry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printWords("she sells sea shells on sea shore");
	}

}
