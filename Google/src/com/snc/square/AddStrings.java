package com.snc.square;

public class AddStrings {
	
public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        
        int d1Len = num1.length()-1;
        int d2Len = num2.length()-1;
        int carry=0;
        
        while(d1Len >=0 || d2Len >= 0){
            
            int d1 = d1Len >=0 ? num1.charAt(d1Len)  - '0' : 0;
            int d2 = d2Len >= 0 ? num2.charAt(d2Len) - '0' : 0;
            
            int res = (d1+d2+carry) % 10;
        
            carry=(d1+d2+carry)/10;
            sb.append(res);
            d1Len--;
            d2Len--;
            
            
        }
        
        if(carry != 0)
            sb.append(carry);
            
            return sb.reverse().toString();
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
