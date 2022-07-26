package com.snc.phone.arrays;

public class IntegerToEnglishWords {
	
	//https://leetcode.com/problems/integer-to-english-words/solution/
	
//  Time complexity : \mathcal{O}(N)O(N). Intuitively the output is proportional to the number N of digits in the input.
//Space complexity : \mathcal{O}(1)O(1) since the output is just a string.
 
 private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
 //if reminder is less than 20  then go to taht position and return for eg if it is 19 go to 19 position and get Nineteen
 private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", 
 "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
  "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
 //if reminder is less than 100 i we can mod by 10 get 2 and go to 2nd position an dreturn twenty
 private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
  "Sixty", "Seventy", "Eighty", "Ninety"};

 public String numberToWords(int num) {
      if (num == 0) return "Zero";
     StringBuilder sb = new StringBuilder();
     int index = 0;
     while (num > 0) {
         if (num % 1000 > 0) {
             StringBuilder tmp = new StringBuilder();
             helper(tmp, num % 1000);
             System.out.println("-->"+tmp.toString());
             tmp.append(THOUSANDS[index]).append(" ");
             sb.insert(0, tmp);
         }
         index++;
         num = num / 1000;
     }
     return sb.toString().trim();
 }
 private void helper(StringBuilder tmp, int num) {
     if (num == 0) {
         return;
     } else if (num < 20) {
         tmp.append(LESS_THAN_TWENTY[num]).append(" ");
         return;
     } else if (num < 100) {
         tmp.append(TENS[num / 10]).append(" ");
         helper(tmp, num % 10);
     } else {
         tmp.append(LESS_THAN_TWENTY[num / 100]).append(" Hundred ");
         helper(tmp, num % 100);
     }
 }

}
