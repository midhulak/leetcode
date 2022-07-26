package com.snc.arrays;

public class ShuffleArray {
	
	
	
	public int[] shuffle(int[] num , int n) {
		
		int[] toRes = new int[num.length];
		
		for(int i=0; i<num.length; i++) {
			
			if(i%2 == 0)
				toRes[i] = num[i/2];
			else
				toRes[i] = num[n+i/2];
		}
		
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
