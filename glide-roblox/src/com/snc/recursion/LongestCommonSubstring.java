package com.snc.recursion;

import java.util.HashMap;

public class LongestCommonSubstring {
	
	
	public static int lcs(String x , String y, int i, int j , int count , HashMap<String , Integer> hm) {
		
		if(i >= x.length() || j >= y.length())
			return count;
		
		String key = i+ "#" + j + "$" + count;
		
		if(hm.containsKey(key))
			return hm.get(key);
			
		int equal = count;
		
		if(x.charAt(i) == y.charAt(j))
			equal = lcs(x, y , i+1, j+1 , count+1 , hm);
		
		int moveSecond = lcs(x, y, i, j+1 , 0 , hm);
		int moveFirst = lcs(x, y, i+1, j, 0, hm);
		
		int res = Math.max(equal , Math.max(moveSecond, moveFirst));
			
		hm.put(key , res);
		
		return res;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
