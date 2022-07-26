package com.snc.compass;
import java.io.*;
import java.util.*;

class pair{
    
    
    String key;
    int val;
    
  }
public class CompassCode {
	
	/*
	 * Click `Run` to execute the snippet below!
	 */

	//Give a list of messages that each has a category and number, find the sublist with maximum sum of message numbers in it and containing at most K different categories.
	//[(“ab”, 1), (“bc”, 2), (“dc”, 1), (“ab”, 5)] k=2   //7

	//diff eg: [(“ab”, 1), (“ab”, 5) ,(ab, 7) , (ab, 8) (ab,89) (“bc”, 2), (“dc”, 1)]   k=2


	//

	//[ ("ab" , 1) ("ab" , 2) ("ab" , 5) (cd ,8) (dc,7) ("ab" , 100)]  k=2. 107  4 , 5

	
	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 */

	  
	  

	
	  
	static  int[] result = new int[2];
	
	
	public static int maxSum(List<pair> pairs, int k) {
        int max = 0;
        int windowStart = 0;
        //int sameMax = 0;
        int windowSum = 0;
        for(int windowEnd = 0; windowEnd < pairs.size(); windowEnd++) {
            while(windowEnd + 1 < pairs.size()
                    && windowEnd < pairs.size()
                    && pairs.get(windowEnd + 1).equals(pairs.get(windowEnd))) {
                //sameMax = Math.max(max, pairs.get(windowEnd));
                windowEnd++;
            }
            pair keyVal = pairs.get(windowEnd);
            windowSum += keyVal.val;
            if(windowEnd > k) {
                max = Math.max(max, windowSum);
                pair keyValStart = pairs.get(windowStart);
                windowSum -= keyValStart.val;
                windowStart++;
            }
        }
        return max;
    }
	  
	  public static int[] getMaxSum(List<pair> pairs , int k){
	    
	   
	    int left=0;
	   int sum=0;
	 
	   // ("ab" , 1) (cd ,8) (dc,7) ("ab" , 100)
	   for(int right=0; right<pairs.size(); right++){
	       while(right < pairs.size() && right+1 < pairs.size() && pairs.get(right).key.equals(pairs.get(right+1).key) ){
	       right++;
	         
	     }
	   
	      
	     k--;
	     
	      
	     while(k < 0){
	      
	         while(left < pairs.size() && left+1 < pairs.size() && pairs.get(left).key.equals(pairs.get(left+1).key)){
	      
	       left++;
	       
	         }
	         left++;
	         
	       k++;
	     }
	     
	     if(k == 0 ) {
		    	int sumSoFar = getSum(left,right,pairs) ;
		    	if(sumSoFar > sum) {
		    	 result[0] = left;
		    	 result[1] = right;
		    	 sum = sumSoFar;
		    	}
		    	 
		     }
	       
	     }
	     
	    
	    
	  
	   System.out.println("index1="+result[0]);
	  System.out.println("index2="+result[1]);
	  System.out.println("sumSoFar="+sum);
	    
	    
	    return result;
	       
	   }
	    
	    
	  
	  public static int getSum(int left, int  right, List<pair> pairs ) {
		  int totSum=0;
		  for(int i=left; i<=right; i++) {
			  totSum+=pairs.get(i).val;
		  }
		  return totSum;
	  }
	  
	  
	  
	  
	  public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    strings.add("This pad is running Java " + Runtime.version().feature());

	    for (String string : strings) {
	      System.out.println(string);
	    }
	    //("ab" , 1) (cd ,8) (dc,7) ("ab" , 100)
	    //[ ("ab" , 1) ("ab" , 2) ("cd" , 5) (cd ,8) (dc,7) ]  k=2. 107
	    pair p = new pair();
	     p.key = "ab";
	    p.val = 1;
	    
	     pair p1 = new pair();
	     p1.key = "cd";
	    p1.val = 4;
	    
	     pair p2 = new pair();
	     p2.key = "dc";
	    p2.val = 2;
	    
	     pair p3 = new pair();
	     p3.key = "bh";
	    p3.val = 10;
	    
	    pair p4 = new pair();
	    p4.key = "kk";
	    p4.val = 23;
	    
	    
	    pair p5 = new pair();
	    p5.key = "ll";
	    p5.val = 3;
	    
	    
	    pair p6 = new pair();
	    p6.key = "mm";
	    p6.val = 1;
	    
	    
	    pair p7 = new pair();
	    p7.key = "ku";
	    p7.val = 0;
	    
	    pair p8 = new pair();
	    p8.key = "ss";
	    p8.val = 20;
	   
	    List<pair> list = new ArrayList<>();
	    
	    list.add(0, p);
	    list.add(1, p1);
	    list.add(2, p2);
	    list.add(3, p3);
	    list.add(4, p4);
	    list.add(5, p5);
	    list.add(6, p6);
	    list.add(7, p7);
	    list.add(8, p8);
	   
	    
	      getMaxSum(list , 4);
	     System.out.println( maxSum(list , 4));
	  }
	


}
