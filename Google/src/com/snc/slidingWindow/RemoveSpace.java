package com.snc.slidingWindow;

public class RemoveSpace {
	
	public static char[] removeSpaces(char[] a) {
		int n= a.length;
		int s = 0; 
		int e=0;

		while(s<n && a[s] != ' ') 
         s++; 

		if(s == n) 
        	return a; 
	e = s+1; 

	while(e < n) {
	  if(a[e] != ' ') {
	     
	    a[s] = a[e]; 
	    s++;
	    e++;
	 }
	
	  else {
		  e++;
	  }
	} 
	
	for(int i=s ; i<a.length; i++) {
		a[i] = ' ';
	}
	return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] ch = {'T' , 'H' , ' ' , 'I' , 'S' , ' ' , ' ' , 'C' , 'A' , ' ', 'T'};
		char[] res = removeSpaces(ch);
		
		for(int i=0 ;i<res.length; i++) {
			System.out.println("result is="+res[i]);
		}
		

	}

}
