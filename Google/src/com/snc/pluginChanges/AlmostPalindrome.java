package com.snc.pluginChanges;

public class AlmostPalindrome {
	
	public static int almostPalindrome(String str) {
		
		int left=0;
		int right=str.length()-1;
		int score=0;
		
		while(left <= right) {
			if(str.charAt(left) != str.charAt(right)) {
				score+=2;
			}
			left++;
			right--;
		}
		return score;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("abba is="+almostPalindrome("abba"));
		System.out.println("racecar is="+almostPalindrome("racecar"));
		System.out.println("abcdcaa is="+almostPalindrome("abcdcaa"));
		System.out.println("aaabbb is="+almostPalindrome("aaabbb"));
		System.out.println("abcdefgh is="+almostPalindrome("abcdefgh"));
		System.out.println("a is="+almostPalindrome("a"));
		
	}

}
