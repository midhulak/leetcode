package com.snc.day1;

public class TowersOfHanoi {
	
	public static void toh(int n , char s , char d , char e) {
		
		if(n == 0)
			return;
		
		toh(n-1 , s , e , d);
		System.out.println("Move "+s+ " to" + d);
		toh(n-1, e , d , s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		toh(10 , 'S' , 'D' , 'A');
	}

}
