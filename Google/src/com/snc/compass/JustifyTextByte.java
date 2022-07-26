package com.snc.compass;

/*
 *   Title: Justify text


 *
 *   Problem:
 *      Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
        You should pack your words in a greedy approach; that is, pack as many words as
        you can in each line. Pad extra spaces ' ' when necessary so that each line has
        exactly maxWidth characters.
        Extra spaces between words should be distributed as evenly as possible. If the
        number of spaces on a line do not divide evenly between words, the empty slots
        on the left will be assigned more spaces than the slots on the right.
        For the last line of text, it should be left justified and no extra space is
        inserted between words.
        Note:
        A word is defined as a character sequence consisting of non-space characters
        only.  Each word's length is guaranteed to be greater than 0 and not exceed
        maxWidth.  The input array words contains at least one word.
 *
 *   Execution: javac JustifyText.java && java JustifyText
 */

//TC: O(n) 
//SC:O(1) 
import java.util.*;

public class JustifyTextByte {
	public static List<String> justifyText(String[] words, int maxWidth) {
		int left = 0;
		List<String> result = new ArrayList<>();

		while (left < words.length) {
			int right = findRight(left, words, maxWidth); //how many words can make a length of 16 it will give how many words
			result.add(justify(left, right, words, maxWidth)); //if last word is overflowoing fill spaces if the characters are not 16
			left = right + 1;
		}

		return result;
	}

	public static int findRight(int left, String[] words, int maxWidth) {
		int right = left; //initially set right to left 
		int sum = words[right++].length(); //and adding word length to sum
//if right is not words.length and actual sum + 1 is space and next word length is less than max then add it to sum
		while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
			sum += 1 + words[right++].length();

		return right - 1;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		if (right - left == 0)
			return padResult(words[left], maxWidth);

		boolean isLastLine = right == words.length - 1;
		int numSpaces = right - left; //if 2 words need 2 spaces
		int totalSpace = maxWidth - wordsLength(left, right, words); //just words length 3 words for eg: This is an total 4+2+2 total 8 chracters and 16-8 = 8 we need 
		//to fit 8 sopaces ....how to fit 8 spaces? we can fit 8 spaces in how many places..how many places will tell left-right if 2 words 1 space 3 words 2 spaces like num of words -1 so we can simply
		//divide totalspaces%numofspazces.
		String space = isLastLine ? " " : blank(totalSpace / numSpaces); 
		int remainder = isLastLine ? 0 : totalSpace % numSpaces; //even if we divide into equal parts but if there is any remainder left will try to add exrtra space

		StringBuilder result = new StringBuilder();
		for (int i = left; i <= right; i++)
			result.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");

		return padResult(result.toString().trim(), maxWidth);
	}

	//calculating just the  words length with out spaces 
	public static int wordsLength(int left, int right, String[] words) {
		int wordsLength = 0;
		for (int i = left; i <= right; i++)
			wordsLength += words[i].length();
		return wordsLength;
	}

	public static String padResult(String result, int maxWidth) {
		return result + blank(maxWidth - result.length());
	}
//tgis will just add equal space between the words
	public static String blank(int length) {
		return new String(new char[length]).replace('\0', ' ');
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;

//		List<String> expectedOut = new ArrayList<String>();
//		expectedOut.add("This    is    an");
//		expectedOut.add("example  of text");
//		expectedOut.add("justification.  ");

		//assert justifyText(words, maxWidth) == expectedOut;
		
		System.out.println(justifyText(words, maxWidth));

		//System.out.println("Passed all test cases");
	}

}