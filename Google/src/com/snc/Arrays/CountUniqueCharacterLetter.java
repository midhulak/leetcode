package com.snc.Arrays;

import java.util.Arrays;

public class CountUniqueCharacterLetter {
	
//	ABC -> 1 * 3 + 2*2 + 3*1 = 10
//			ABA -> 1*2 + 2*2 + 2*1 = 2+4+2 = 8;
//			XAXAXXAX  [prevofPrevIndexj , prevIndex
	
	public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for(int i=0; i < 26; i++){
            Arrays.fill(index[i] , -1);
        }
        
        int res=0, N = s.length() , mod = (int)Math.pow(10,9)+7;
        
        for(int i=0; i<N;i++){
            int c = s.charAt(i) - 'A';
//            int first = i - index[c][1];
//            int sec = index[c][1] - index[c][0];
//            //res = (res + first * sec % mod)% mod;
            res = (res + (i- index[c][1]) * 
           		(index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[]{index[c][1] , i};
        }
        
        for(int c=0; c < 26 ; c++){
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CountUniqueCharacterLetter c = new CountUniqueCharacterLetter();
		System.out.println(c.uniqueLetterString("XAXAXXAX"));
		
	}

}
