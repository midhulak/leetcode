package com.snc.square;

public class EditDistance {
	
	
//	public int minEdit(String s1 , String s2) {
//		
//		
//		return minEditBackTrack(s1,s2,0,0);
//	}
	
	public static int minEditBackTrack(String s1 , String s2 ) {
		
		if(s1.length() == 0) {
			return s2.length();
		}
		if(s2.length() == 0) {
			return s1.length();
		}
		
		
		if(s1.charAt(0) == s2.charAt(0)) {
		 return minEditBackTrack(s1.substring(1) , s2.substring(1));
		}
		
		int insert = minEditBackTrack(s1.substring(0) , s2.substring(1)) + 1;
		int delete = minEditBackTrack(s1.substring(1) , s2.substring(0))+ 1;
		int replace = minEditBackTrack(s1.substring(1) , s2.substring(1))+ 1;
		
		return   Math.min(insert ,Math.min(delete, replace));
			
	}
	
	
public static int minEditBackTrackMemo(String s1 , String s2 , int[][] arr) {
		
		if(s1.length() == 0) {
			return s2.length();
		}
		if(s2.length() == 0) {
			return s1.length();
		}
		
		if(arr[s1.length()][s2.length()] > 0)
			return arr[s1.length()][s2.length()];
		
		if(s1.charAt(0) == s2.charAt(0)) {
			arr[s1.length()][s2.length()] = minEditBackTrack(s1.substring(1) , s2.substring(1));
		 return minEditBackTrack(s1.substring(1) , s2.substring(1));
		}
		
		int insert = minEditBackTrack(s1.substring(0) , s2.substring(1)) + 1;
		int delete = minEditBackTrack(s1.substring(1) , s2.substring(0))+ 1;
		int replace = minEditBackTrack(s1.substring(1) , s2.substring(1))+ 1;
		
		return   Math.min(insert ,Math.min(delete, replace));
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("min distance is="+minEditBackTrack("abc" , "cba"));
	}

}
