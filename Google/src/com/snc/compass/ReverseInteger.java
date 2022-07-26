package com.snc.compass;

public class ReverseInteger {
	
	//123 
	//321
	
	public static int reverseInteger(int num) {
		
		int temp=0;
		while(num != 0) {
			
			temp = 10*temp+num%10;
			num=num/10;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverseInteger(1234));
	}

}
