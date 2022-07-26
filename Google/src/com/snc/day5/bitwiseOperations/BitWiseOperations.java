package com.snc.day5.bitwiseOperations;

public class BitWiseOperations {

	public static  int setBit(int x , int n) {
		int m = 1 << n;
		
		return (x|m);
	}
	public static int powerOfTwo(int n) {
		System.out.println(1<<n);
		return 1<<n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(powerOfTwo(8));
		
	
//		  System.out.println(1<<4);
//		 System.out.println(setBit(5 , 4));
	}
	

}
