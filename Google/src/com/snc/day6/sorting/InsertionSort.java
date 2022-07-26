package com.snc.day6.sorting;

public class InsertionSort {

	void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
	
	
	for(int i=0 ; i<arr.length; i++) {
		
		int j =i;
		while(j > 0 && arr[j-1] > arr[j]) {
			swap(arr[j] , arr[j-1]);
			j=j-1;
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
