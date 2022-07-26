package com.snc.arrays.strings;

import java.util.Arrays;

public class PlusOne {
	
	   /**
    Let NN be the number of elements in the input list.

Time complexity: \mathcal{O}(N)O(N) since it's not more than one pass along the input list.

Space complexity: \mathcal{O}(N)O(N)

Although we perform the operation in-place (i.e. on the input list itself), in the worst scenario, we would need to allocate an intermediate space to hold the result, which contains the N+1N+1 elements. Hence the overall space complexity of the algorithm is \mathcal{O}(N)O(N).
**/
    //add extra 1 length to digs array if it is last digit add plus one na dif not last digit just add sum plus numbe rin that digit
    //every time add carry to the existing numbe rin digit array.
        public int[] plusOne(int[] digits) {
       int sum=0;
        int val=0;
     int[]  digs = new int[digits.length+1];
       
        for(int i=digits.length-1 ; i>=0 ; i--){
            
            if(i== digits.length-1){
             sum = digits[i]+1;
            }
        else{
            sum = digits[i]+sum;
        }
            val = sum%10;
            
            digs[i+1]=val;
            
            sum = sum/10;
           
            if(i==0 && sum != 0){
                digs[0]=sum;
            }
           
        }
        
        
        
        if(digs[0] == 0){
            return Arrays.copyOfRange(digs , 1 , digs.length);
        }
        return digs;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
