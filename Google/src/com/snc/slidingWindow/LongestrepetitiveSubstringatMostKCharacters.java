package com.snc.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestrepetitiveSubstringatMostKCharacters {
	//idea is find out the frequency of each character if frequency is leaas than we can split the
	//string into left and keep on moving until we find nay character of count greater tahn k right and call the recursion
	
	public static int longestRepetitive(String str , int k) {
		int n = str.length();
		
		if(k <= 1)
			return n;
		
		if(n < k || n == 0)
			return 0;
		
		Map<Character , Integer> map = new HashMap<Character , Integer>();
		
		for(int i=0 ; i<n; i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
		}
		
		//sliding logic starts
		int l=0;
		while(l<n && map.get(str.charAt(l)) >= k) 
			l++;
		
		if(l >= n-1)
			return l;
		
		int left = longestRepetitive(str.substring(0 , l) , k);
		
		while(l <n && map.get(str.charAt(l)) < k)
			l++;
		
		int right = (l<n) ? longestRepetitive(str.substring(l) , k) : 0;
		
		return Math.max(left ,  right);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aaabb";
		
		System.out.println(longestRepetitive(s , 3));
	}

}
