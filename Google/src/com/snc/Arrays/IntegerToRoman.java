package com.snc.Arrays;

public class IntegerToRoman {
	

	    //checking if given number is n between  keep on iterating teh loop whcih is falls in between 1000 to 1 and if the number is close to teh values then decrementing the number with values[i]
	    //if greater also decrementing it until it find 
	    public static  String intToRoman(int num) {
	        
	        int[] values=       {1000 , 900 , 500, 400, 100 , 90 , 50 , 40 , 10 ,9, 5 , 4 , 1};
	        String[] symbols = {"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" ,"X","IX", "V" , "IV" , "I"};
	        StringBuffer sb = new StringBuffer();
	        for(int i=0 ; i <values.length && num>=0 ; i++){
	             
	         
	            while(values[i] <= num){
	                num-=values[i];
	                sb.append(symbols[i]);
	            }
	            
	        }
	        return sb.toString();
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(78));

	}

}
