package com.snc.day6.sorting;

public class SelectionSort {
	
	
	
	public static int[] insertion(int[] a) {
		
		for(int i=1 ; i<a.length; i++) {
			int tem = a[i];
			int j=i-1;
			while(j>=0 && tem<a[j]) {
				
				a[j+1] = a[j];
				
				j--;
				
			}
			
			a[j+1] = tem;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] a = {4,2,5,10,9,8,1};
     insertion(a);
     
     for(int i=0 ; i<a.length; i++) {
    	 System.out.println(a[i]);
     }

	}

}
