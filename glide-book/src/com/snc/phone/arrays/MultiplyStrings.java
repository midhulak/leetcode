package com.snc.phone.arrays;

import java.util.Arrays;

public class MultiplyStrings {
	
	/**
	 *   /**
    Time complexity: O(M^2 + M * N)

During multiplication, we perform NN operations for each of the MM digits of the second number; this requires O(M \cdot N)O(M⋅N) time. Then we add each of the MM multiplication results (of length O(N + M)O(N+M)) to the answer string; this requires O(M \cdot (M + N))O(M⋅(M+N)) time.

When we multiply a number with one digit, the result's maximum length can be at most one more than the number's length (We can see that when we multiply the max integer of d digits, i.e., 9...99 with 9) and there can be at most (M-1) zeroes initially appended to the result. Hence, each result is of order O(N + M)O(N+M).

Summing the results requires iterating over the length of the current answer for each result. Since the length of two numbers multiplied together cannot be longer than the sum of the lengths of the two numbers, iterating over each digit in the answer will take O(M + N)O(M+N) time and we will do so M - 1M−1 times (for all but one of the MM results). So this step takes O(M \cdot (M + N))O(M⋅(M+N)) time.

Finally, reversing the answer will require O(M + N)O(M+N) time. Taking all steps into consideration, the total time complexity is O(M^2 + M \cdot N)O(M 
2
 +M⋅N).

Space complexity: O(M^2 + M*N)O(M 
2
 +M⋅N).

We store each result of multiplication for each digit of num2 with num1 in the results array. Each multiplication result can have at most N + MN+M length, and there will be MM such results. Thus the space complexity is O(M \cdot (M + N))O(M⋅(M+N)).
**/
	 /* @param num1
	 * @param num2
	 * @return
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
	                //get the product 
	                int product = (char1[i] - '0') * (char2[j] - '0');
	                
	                //and add the product to the previous offset
	                int tmp = res[i+j+1] - '0' + product;
	               
	                //get the mod of it and add the result to the position i and j +1 
	                res[i + j + 1] = (char)(tmp % 10 +'0');
	                //and add carry to the previous position by dividing by 10
	                res[i + j] = (char) ( (res[i+j]- '0' + tmp/10) + '0');
	                
	            }
	        }
	        //and printing those , and while displaying need to eleiminate first zeros
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
