package com.snc.arrays.strings;

import java.util.Arrays;

public class FindReplaceString {
	
	/**https://leetcode.com/problems/find-and-replace-in-string/submissions/ **/
	
	public String findReplaceString(String s , int[] indexes, String[] sources , String[] targets) {
		
		int n = s.length();
		int[] match = new int[n];
		Arrays.fill(match ,  -1);
		
		for(int i=0; i < indexes.length; i++) {
			
			if(s.substring(indexes[0] , indexes[0]+sources[i].length()).equals(sources[i])) {
				match[indexes[i]] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n;) {
			
			if(match[i] != -1) {
				
				sb.append(targets[match[i]]);
				i+=sources[match[i]].length();
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
