package com.snc.phone.arrays;

public class ReadNCharactersGivenRead4 {

	// Time complexity: O(N)O(N) to copy N characters.

	// Space complexity: O(1)O(1) to keep buf4 of 4 elements.
	
	//https://leetcode.com/problems/read-n-characters-given-read4/
public int read(char[] buf, int n) {
        
        int copiedChars =0;
        int readChars = 4;
        
        char[] buf4 = new char[4];
        //very first time have to enter into loop so readChars is 4
        while(copiedChars < n && readChars == 4){ // suppose if readCharacters is 3 for eg; buff has only 3 characters then we can stop and return whatever 
            readChars = read4(buf4); //tis is api from leetcode.
            
            
            for(int i=0 ; i < readChars; i++){  //copying teh characters from buf4 to buf if buf length is equal to n then return.
                
                if(copiedChars == n)
                    return copiedChars;
                
                buf[copiedChars] = buf4[i];
                ++copiedChars;
            }
            
            
        }
        
        return copiedChars;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
