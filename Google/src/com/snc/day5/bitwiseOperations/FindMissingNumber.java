package com.snc.day5.bitwiseOperations;

public class FindMissingNumber {
	
	public static  int missingNumber(int[] a) {
		
		int x = a.length+1;
		
		for(int i=0 ; i<a.length; i++) {
			x=x^a[i]^i+1;
		}
		return x;
	}
	
	public static int findMissAndRepeat(int[] a) {
		int x = a[0];
		
		for(int i=1 ; i<a.length; i++) {
			x=x^a[i];
		}
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] a = {1,2,3,5,6,7,8,9};
//		System.out.println(missingNumber(a));
		
		int[] a1 = {1,2,3,3,5};
		System.out.println("miss and repeat="+findMissAndRepeat(a1));
		
	
		
	}

}
