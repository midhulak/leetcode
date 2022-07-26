package com.snc.phone.arrays;

public class OneEditDistance {
	//https://leetcode.com/problems/one-edit-distance/
	
	// TC: O(n)
    //  SC:O(1)
 public boolean isOneEditDistance(String s, String t) {
     int n1=s.length();
     int n2 = t.length();
     //always get the smallest length string first
     if(n1 > n2)
         return isOneEditDistance(t , s);
     
     for(int i=0; i<n1; i++){
      //if not equal 
         if(s.charAt(i) != t.charAt(i)){
             
             //if length is same and this character in both places not equals and ignoring this piece and checking the rest of string is equal or not
             if(n1 == n2){
                 return s.substring(i+1).equals(t.substring(i+1));
             }
             //if both characters are not equal and length of string not same then do not move the smallest string and move 1 position right to bigger string and see rest of characters are equal or not
             else
                 return s.substring(i).equals(t.substring(i+1));
             
         }
         
     }
     //otherwise if all characters are equal then check the length of both are differ by one if they are equal also we shud return false;
     return (n1+1 == n2);
     
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
