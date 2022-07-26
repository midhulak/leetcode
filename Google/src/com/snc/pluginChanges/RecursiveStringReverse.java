package com.snc.pluginChanges;

public class RecursiveStringReverse {
	
	public static String recursiveStringReverse(String string) {
		if(string.length() <= 1) {
			return string;
		}
		String firstCharacter = string.substring(0,1);
		String lastCharacters = string.substring(1);
		
		return recursiveStringReverse(lastCharacters) + firstCharacter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(recursiveStringReverse("midhula"));
	}

}
