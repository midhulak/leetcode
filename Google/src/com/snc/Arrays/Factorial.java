package com.snc.Arrays;

public class Factorial {
	
	int[] fact = new int[100];
	public  int factorial(int n) {
		
		if(n == 0 || n == 1)
			return 1;
		else {
		if(fact[n] != 0)
			return fact[n];
		else {
			return fact[n] = n * factorial(n-1);
		}

}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
