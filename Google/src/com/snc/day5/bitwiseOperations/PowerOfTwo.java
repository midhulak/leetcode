package com.snc.day5.bitwiseOperations;

public class PowerOfTwo {
	
	public static boolean isPowerOfTwo(int n) {
		
		if(n == 0)
			return false;
		
		if(n%2 ==1)
			return false;
		
		if(n!=1)
			 isPowerOfTwo(n/2);
		
		return true;
	}
	
	//getting bits at given position from right to left starting with 0 index
	public static int getBit(int x , int n) {
		int m = 1<<n;
		if((x&m) == 0)
			return 0;
		else
			return 1;
	}
	
	//set bit 1 at current position from right to left starting with 0 index
	public static int setBit(int x, int n) 
	{ 
    int m = 1<<n; 
    return (x|m); 
	} 		

	//reset bit 0 at current position from right to left starting with 0 index
	public static int resetBit(int x, int n) 
    { 
	int m = ~(1<<n); 
	return (x&m); 
	} 
	
	public static int toggleBit(int x, int n) 
	{ 
	int m = 1<<n; 
    return (x^m); 
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(25));
		
		System.out.println("get 2nd position of 5="+getBit(5 , 2));
	}

}
