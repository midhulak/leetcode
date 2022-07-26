package com.snc.sorting;

public class MergeSortedArray {
	
	public static void merge_first_into_second(int[] arr1 , int[] arr2) {
		
		  
        int i=arr1.length-1;
        int j=arr1.length-1;
        int k = arr2.length-1;
        
        while(i >=0 && j>=0){
        	
             if( arr1[i] > arr2[j]){
                
                arr2[k] = arr1[i];
                i--;
               
            }
            else 
            {
                arr2[k] = arr2[j];
                j--;
              
            }
            
            k--;
        }
        
      while(i >=0) {
    	  arr2[k] = arr1[i];
    	  k--;
    	  i--;
      }
        
          
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr1= {1,3,5};
		int[] arr2 = {2,4,6,0,0,0};
		
		merge_first_into_second(arr1 , arr2);
		
		for(int i=0 ; i<arr2.length; i++) {
			System.out.println("arr2 is="+arr2[i]);
		}
	}

}
