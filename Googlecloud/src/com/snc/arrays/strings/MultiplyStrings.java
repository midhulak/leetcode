package com.snc.arrays.strings;

import java.util.Arrays;

public class MultiplyStrings {
	
	 /*
    Here NN and MM are the number of elements in num 1 and num 2 strings.

Time complexity: O(M \cdot (N+M))O(M⋅(N+M)).

During multiplication, we perform N operations for each of the M digits of the second number, so we need O(M \cdot N)O(M⋅N) time for it.
We add the multiplication result to the ans string that has a length of N+MN+M. There will be MM such additions since we have MM multiplication results. Therefore, the time consumed here will be O(M \cdot (N+M))O(M⋅(N+M)).
It takes linear time to reverse the strings.
Overall, this solution takes O(M \cdot N + M \cdot (N+M) + M + N) = O(M \cdot (N+M))O(M⋅N+M⋅(N+M)+M+N)=O(M⋅(N+M)) time.
Space complexity: O(N + M)O(N+M).

The answer string and multiplication results will have at most N + MN+M length.


*/
      public String multiply(String num1, String num2) {
        
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        
        int n1 = char1.length;
        int n2 = char2.length;
        
        char[] res = new char[n1+n2];
        
        Arrays.fill(res,'0');
        
        
    
        for(int j=n2-1; j>=0 ; j--){
            
            for(int i=n1-1; i>=0; i--){
                
                int product = (char1[i] - '0') * (char2[j] - '0');
                
                int tmp = res[i+j+1] - '0' + product;
               
                res[i + j + 1] = (char)(tmp % 10 +'0');
                
                res[i + j] = (char) ( (res[i+j]- '0' + tmp/10) + '0');
                
            }
        }
        
        StringBuffer sb = new StringBuffer();
        boolean seen = false;
        for(char c : res){
            if(c == '0' && !seen)
                continue;
            sb.append(c);
            seen=true;
        } 
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
