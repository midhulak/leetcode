package com.snc.gotanoffer.arrays;

public class LongestPalindromicSubString {
	
    //checking the values left character and right character if equal will keep on extending
    //and alo if even length checking charcter current with left charcater if equal will keep on extending left and right
    //aba our left index is 0 an drigth index is 2 which is a, a if both a and a are equal will keep decrementing leftindex and incrementing right index
    //xyzzyx suppose left index is 2 and right index is 3 and  z,z and both are equal if equal will decrement leftindex to y(i.e 1) and increment rght index y(i.e 4) and keep on exetending
    
    //and finally see which one is longest will return that
	
	//TC: O(n^2) time | O(n) space
   
	public static String longestPalindrome(String str) {
		
		int[] currentLongest = {0,1};
		
		for(int i=1 ; i < str.length(); i++) {
			
			int[] odd = getLongestPlaindromeFrom(str , i-1 , i+1);
			int[] even = getLongestPlaindromeFrom(str , i-1 , i);
			
			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			
			currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest; 
		}

		return str.substring(currentLongest[0] , currentLongest[1]);
	}
	
	public static int[] getLongestPlaindromeFrom(String str , int leftIdx , int rightIdx) {
		
		while(leftIdx >= 0 && rightIdx < str.length()) {
			
			if(str.charAt(leftIdx) != str.charAt(rightIdx))
				break;
			
			leftIdx--;
			rightIdx++;
		}
		return new int[] {leftIdx+1 , rightIdx};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
