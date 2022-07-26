package com.snc.compass;

public class MinimalRemoveMakeValid {
	
	public String minRemoveToMakeValid(String s) {
		int count=0;
		StringBuffer result = new StringBuffer();
		
		for(int i=0; i<s.length(); i++) {
			
			if(count == 0 && s.charAt(i) == ')')
				continue;
			if(s.charAt(i) == '(')
				count++;
			if(s.charAt(i) == ')')
				count--;
			
			result.append(s.charAt(i));
		}
		while(count > 0) {
			result.deleteCharAt(result.lastIndexOf("("));
			count--;
		}
		return result.toString();
	}
	
	
	public static String makeItValid(String s){
	    int openCount=0;
	    int closeCount=0;
	    
	    for(int i=0 ; i<s.length(); i++){
	     
	      if(s.charAt(i) == '(')
	        openCount++;
	      
	       if(s.charAt(i) == ')')
	        closeCount++;
	      
	    
	      if(closeCount > openCount){
	       int lastSeenClose = s.indexOf(')'); //2
	       // System.out.println("lastSeenClose="+lastSeenClose);
	        
	       s = charRemoveAt(s , lastSeenClose);
	        i=i-1;
	        closeCount = openCount;
	       // System.out.println("debud statme"+s);
	       // System.out.println(str);
	        
	       // (()))()
	        // if(isValid(charRemoveAt(s , lastSeenClose))){
	        //   return s;
	        // }
	      }
	      
	      
	    }
	    
	    
	    
	      if(openCount > closeCount){
	        int timesToRemove = Math.abs(openCount-closeCount);
	        
	        while(timesToRemove != 0){
	          
	          int lastSeenOpen = s.lastIndexOf('(');
	            s=charRemoveAt(s , lastSeenOpen);
	         
	          timesToRemove--;
	          
	        }
	      }
	       
	  return s;
	    
	  }
	  
	   public static String charRemoveAt(String str, int p) {  
	              return str.substring(0, p) + str.substring(p + 1);  
	           }  
	  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
