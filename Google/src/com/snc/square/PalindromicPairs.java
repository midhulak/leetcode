package com.snc.square;

import java.util.HashSet;
import java.util.Set;

public class PalindromicPairs {
	
//first put reverse words of string in an set and every word check does it present in set or not..if in set then it males
	//a palindromic pair with some other word.
	
	//if it doe snot make a pair we can not conclude that it doe snot make a pair..need to take out each character from string 
	//and check the takenout string is palindrome if yes check teh remaining string exists or not..
	//if not again take out 1 more string and check keep doing this until we find the match
	//repaet this process from front and back both.
	
	  // Check whether the given string is a palindrome or not.
	  private boolean isPalindrome(String string) {
	    int left = 0;
	    int right = string.length() - 1;
	    while (left < right) {
	      if (string.charAt(left) != string.charAt(right)) {
	        return false;
	      }

	      left++;
	      right--;
	    }

	    return true;
	  }

	  // Returns the reversed string of the given string.
	  private String reverseWord(String str) {
	    // Leverage the existing library "StringBuilder" to reverse a string.
	    return  new StringBuilder(str).reverse().toString();
	  }

	  private Set<String> findPalindromesHelper(
	          String word, Set<String> reversedWords) {
	    Set<String> palindromes = new HashSet<>();


	    // Check if we can form a palindrome by concatenating two words with the
	    // same length.
	    if (reversedWords.contains(word)) {
	      // Prevent forming a palindrome with a single word.
	      String reversedWord = reverseWord(word);
	      if (!reversedWord.equals(word)) {
	        palindromes.add(word + reversedWord);
	      }
	    }

	    // Check if we can form a palindrome by concatenating two words with
	    // different length by appending the other word to the back of the
	    // given word.
	    for (int i = 1; i < word.length() - 1; i++) {
	      String takenOutStr = word.substring(word.length() - i);
	      String remainingStr = word.substring(0, word.length() - i);
	      if (isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)) {
	        String palindrome =
	                remainingStr + takenOutStr + reverseWord(remainingStr);
	        palindromes.add(palindrome);
	      }
	    }

	    // Check if we can form a palindrome by concatenating two words with
	    // different length by appending the other word to the front of the
	    // given word.
	    for (int i = 1; i < word.length() - 1; i++) {
	      String takenOutStr = word.substring(0, i);
	      String remainingStr = word.substring(i);
	      if (isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)) {
	        String palindrome =
	                reverseWord(remainingStr) + takenOutStr + remainingStr;
	        palindromes.add(palindrome);
	      }
	    }

	    return palindromes;
	  }

	  Set<String> findPalindromes(List<String> words) {
	    // Reverse each word and put it in a set.
	    Set<String> reversedWords = new HashSet<>();
	    for (String word : words) {
	      reversedWords.add(reverseWord(word));
	    }

	    // Iterate through each word and check if we can pair up with another
	    // word to form a palindrome.
	    Set<String> palindromes = new HashSet<>();
	    for (String word : words) {
	      Set<String> palindromePairs =
	              findPalindromesHelper(word, reversedWords);
	      palindromes.addAll(palindromePairs);
	    }

	    return palindromes;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
