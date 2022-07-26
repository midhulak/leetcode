package com.snc.day7.graphs;

public class FindAllPrimes {
	
	
	
	public static void  allPrimes(int N , boolean[] isPrime) {
		
		
		isPrime[0] = false;
		
		for(int i=1 ; i<=N ; i++) {
			isPrime[i] = true;
		}
		
		
		for(int i=2 ; i<= N ; i++) {
			if(isPrime[i]) {
				
				if(i > 1000)
					System.out.println(i);
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] isPrime = new boolean[9999+1];
		allPrimes(9999  , isPrime);
		
//		for(int i=1000 ; i<isPrime.length; i++) {
//			if(isPrime[i])
//				System.out.println(i);
//		}

	}

}
