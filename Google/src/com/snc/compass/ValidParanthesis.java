package com.snc.compass;

public class ValidParanthesis {

	 public static boolean checkValidString(String s) {
	       
	        int lo=0;
	        int hi=0;
	        
	        for(char c : s.toCharArray()){
	            lo+= c == '(' ? 1 : -1;
	            hi+= c != ')' ? 1 : -1;
	            if(hi < 0)
	                break;
	               lo = Math.max(lo , 0);
	        }
	        return lo == 0;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "(((*))";
		System.out.println(checkValidString(s));
		
	}

}
