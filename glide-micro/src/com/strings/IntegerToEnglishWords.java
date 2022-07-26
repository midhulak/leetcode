package com.strings;

public class IntegerToEnglishWords {
	
private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", 
    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToEnglishWords intEng = new IntegerToEnglishWords();
		System.out.println(intEng.numberToWords(124567897));

	}

}
